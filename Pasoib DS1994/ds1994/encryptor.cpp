#include <stdio.h>
#include <conio.h>
#include <string>
#include <iostream>
#include <fstream>
#include "encryptor.h"

using namespace std;

const string original_file_path = "visitka_original.dat";
const string encrypted_file_path = "visitka_encrypted.dat";
const string decrypted_file_path = "visitka_decrypted.dat";

void encrypt()
{
    // opens streams to read original file and write encrypted
    ifstream ifs(original_file_path, ios::in);
    ofstream ofs(encrypted_file_path);

    if (!ifs) {
        cout << "Cannot open the original vcard file.\n";
        return;
    }
    if (!ofs) {
        cout << "Cannot open file for the encrypted vcard.\n";
        return;
    }

    // while not the end of the file
    char next_char;
    while (!ifs.eof())
    {
        ifs.get(next_char);
        ofs << static_cast<char>(next_char + 1);
    }

    ifs.close();
    if (!ifs.good()) {
        cout << "Error occurred while reading or closing the original vcard file.\n";
        return;
    }

    ofs.close();
    if (!ofs.good()) {
        cout << "An error occurred when writing to the encrypted vcard file.\n";
        return;
    }
}


void decrypt()
{
    // opens streams to read original file and write encrypted
    ifstream ifs(encrypted_file_path, ios::in);
    ofstream ofs(decrypted_file_path);

    if (!ofs) {
        cout << "Cannot open file for the decrypted vcard.\n";
        return;
    }
    if (!ifs) {
        cout << "Cannot open file for the encrypted vcard.\n";
        return;
    }

    // while not the end of the file
    char next_char;
    while (!ifs.eof())
    {
        ifs.get(next_char);
        ofs << static_cast<char>(next_char - 1);
    }

    ifs.close();
    if (!ifs.good()) {
        cout << "Error occurred while reading or closing the encrypted vcard file.\n";
        return;
    }

    ofs.close();
    if (!ofs.good()) {
        cout << "An error occurred when writing to the decrypted vcard file.\n";
        return;
    }
}