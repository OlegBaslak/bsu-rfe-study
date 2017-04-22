/*********************************************************************
*	������ ���������, ��������� TMEX ��� ������ � ����� 1-Ware,      *
* ��������� ���������� ����� � ��� ������ � ���������� DS1994 �
*� ��������� ������������� ������� ������  � ������ ������ � ��������.                                                                             *
**********************************************************************/

/* ������ � ������ � TMEX (��������� ���������� � ������� ����� ����� � SDK).
����� ������� ������ � ����� 1-Wire ���������� �������� ������ � �����,
��� ���� ���������� ������� TMExtendedStartSession, ����������� � ��������
���������� ��� � ����� �����, ������� � ���� ������� ����� �������� �� �������
(���� �������� ��������� ���������) �������� TMReadDefaultPort. �������
TMExtendedStartSession ���������� ���������� ������, ������� ����� ������������
� �������� TMEX. ����� ���������� �������� ������ � ���� 1-Wire, ��� ����
���������� ������� TMSetup. ����� ����� ����� �������� � �����, �.� ������
����������� ����������(�������� ����� ��� ��������� ��� ���������� �����),
����� ����������� ������-���� ���������� � �.�.
    ������ � ����������� �������������� � �������������� ��� ����������� ������,
������� �������� �� ���������� ������ � ����� ���� ���������� ���������������
(������� TMRom ��������� � ������������� ���� �����) ��� ��������( ������� TMSearch,
TMFirst � �.�.). ����� ��� ��� ������ ������ � ����������� ��� ���������� �������
�������� TMAccess, ������� �������� ��� ������ ���������� � ���������� �������,
������� � ������ ������ ������� �������� �� ���������� ������ � ������ ���� �������
�������������. ����� ��������� ������� � ���������� � ��� ����� ��������� �����������
��������. ����� ���������� ���� �������� � ����� ���������� ���������� ������� ����
�������� TMEndSession.
    ��� ���� ���������:
    ��� ����������� ������� TMEX � �������� ��������� ���������
����� ���������, � �� ��������� ��������� ���������� ��������� ����, � ����� ��
������������ ��� ������������� ������ ��� ������/������. ��� �������� ��� �������
� ������������ � ������ �� �����, �� � �������� �� SDK �� ������ ������� ������,
��� ���������� ������ ����������, � ������� ���������� ��������.
    ��� ����������� � ������������ ��������, � ����� ��������� �������� �������
� ������� �� ������������� ����� ����� � SDK. � ����������� ������� 4.00b(1-Wire SDK
����� �� ����� www.dalsemi.com).
*/

#include "Ibtmexcw.h"
#include <stdio.h>
#include <conio.h>
#include <string>
#include <iostream>
#include "sha256.h"
#include "main.h"
#include "encryptor.h"

#define ROM_LEN 8
#define PAGES_NUM 16
#define PAGE_SIZE 32
#define MEMORY_LEN PAGES_NUM*PAGE_SIZE
using namespace std;

enum WorkingMode { READ, WRITE };

const short password_size = 32;
char tstr[100];
uchar buffer[5000];
uchar* ibutton_memory = &(buffer[ROM_LEN]);
uchar* ROM = buffer;
short s_ROM[9];
WorkingMode working_mode = READ;

int main()
{
    setlocale(LC_ALL, "Russian");
    uchar state_buffer[5120];                                   // Buffer for TMEX API
    short port_num, port_type;                                  // Port number and type
    long session_handle;                                        // Session descriptor

    read_1wire_adapter(port_num, port_type);
    start_session(session_handle, port_num, port_type);

    // Main cycle
    printf("Searching for a DS1994...\n");

    bool operation_is_successfull = false;

    if (working_mode == WRITE) printf("Writing node is Enabled!\n");

    for (;;) {

        Sleep(10);

        // Trying to search DS1994
        if (ds1994_search(session_handle, state_buffer) == 0)
            continue;

        switch (working_mode) {
        case WRITE: {
            operation_is_successfull = write_button_key(sha256(input_password()), session_handle, state_buffer);
            if (operation_is_successfull) {
                encrypt();
            }
            break;
        }
        case READ:
        default: {
            operation_is_successfull = is_password_correct(sha256(input_password()), session_handle, state_buffer);
            if (operation_is_successfull) {
                print_vcard();
                decrypt();
            }
            break;
        }
        }

        if (operation_is_successfull) break;
    }

    // Close session
    TMEndSession(session_handle);
    printf("Session closed\n");

    return 0;
};

void read_1wire_adapter(short& port_num, short& port_type) {
    if (TMReadDefaultPort(&port_num, &port_type) < 1)
    {
        printf("ERROR, Could not read the default PortNum and PortType from registry!\n");
        exit(1);
    }

    if (TMGetTypeVersion(port_type, tstr) < 0)//��������� �������� ��������
    {
        printf("ERROR.No Hardware Driver for this type found!\n");
        exit(1);
    }

    printf("%s\n", tstr);
}

void start_session(long& session_handle, short& port_num, short& port_type) {
    session_handle = TMExtendedStartSession(port_num, port_type, NULL);

    if (session_handle == 0)
    {
        printf("ERROR, port not available, it is being used by another application.\n");
        exit(1);
    }

    else if (session_handle < 0)
    {
        printf("No Hardware Driver for this type found!\n");
        exit(1);
    }

    printf("Setup 1-Wire network: ");

    if (TMSetup(session_handle) != 1)
    {
        printf("Error!\n");
        printf("Ending session: ");
        TMEndSession(session_handle);
        printf("Ok\n");
        exit(1);
    }

    printf("Ok\n");
}

string input_password()
{
    cout << "Enter password: ";
    string pswd;
    cin >> pswd;

    return pswd;
}

void try_access_device(long& session_handle, uchar* state_buffer) {
    if (TMAccess(session_handle, state_buffer) != 1)
    {
        printf("Accessing to ds1994:");
        printf("ERROR!\n");
        printf("Ending session: ");
        TMEndSession(session_handle); //��������� ������ � ������ ������.
        printf("Ok\n");

        exit(1);
    }
}

bool write_button_key(string key, long& session_handle, uchar* state_buffer) {
    BYTE hexPswd[32];
    for (unsigned int i = 0; i < key.length(); i += 2) {
        string byteString = key.substr(i, 2);
        hexPswd[i / 2] = (char)strtol(byteString.c_str(), NULL, 16);
    }

    int size = TMWritePacket(session_handle, state_buffer, 0, (BYTE*)hexPswd, password_size);

    if (size < 0) {
        printf("TMWritePacket failed: %i\n", size);
        return false;
    }

    return true;
}

bool is_password_correct(string key, long& session_handle, uchar* state_buffer) {
    BYTE inputKey[32];
    for (unsigned int i = 0; i < key.length(); i += 2) {
        string byteString = key.substr(i, 2);
        inputKey[i / 2] = (char)strtol(byteString.c_str(), NULL, 16);
    }

    BYTE savedKey[32];
    int size = TMReadPacket(session_handle, state_buffer, 0, (BYTE*)savedKey, password_size);
    if (size == 0) {
        printf("TMReadPacket failed: %i\n", size);
        return false;
    }

    if (!memcmp(inputKey, savedKey, sizeof(key))) {   //���������� ������
        return true;
    }

    printf("Wrong key\n");
    return false;
}

void print_vcard() {
    printf("Baslak Oleg Viktorovich\n");
    printf("Students\n");
    printf("Studnet of BSU, RFiKT\n");
    printf("BSU 2017 (�)\n");
}

bool ds1994_search(long session_handle, uchar * state_buffer)
{
    short s_ROM[9];

    // ������������� ���������, ���������� �������� ����� ������.
    if (TMFamilySearchSetup(session_handle, state_buffer, 0x04) == 1)
    {
        // ���� ������ ���������� ������������ ���������
        if (TMNext(session_handle, state_buffer) == 1)
        {
            s_ROM[0] = 0;
            TMRom(session_handle, state_buffer, s_ROM);
            // ��������� ������������ ������
            if ((0x04 & 0x7F) == (s_ROM[0] & 0x7F))
            {
                return true;
            }
        }
    }

    return false;
}
