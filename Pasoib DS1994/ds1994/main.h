#pragma once
#include <string>

void save_memory(char* filename, uchar* _memory, int len);
void load_memory(char* filename, uchar* _memory, int len);

int main();
bool ds1994_search(long session_handle, uchar * state_buffer);
void read_1wire_adapter(short & port_num, short & port_type);
void start_session(long & session_handle, short & port_num, short & port_type);
std::string input_password();
void try_access_device(long & session_handle, uchar * state_buffer);
bool write_button_key(std::string key, long & session_handle, uchar * state_buffer);
bool is_password_correct(std::string key, long & session_handle, uchar * state_buffer);
void print_vcard();
