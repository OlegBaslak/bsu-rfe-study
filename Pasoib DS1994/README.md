# DS1994 encrypter
This program works with DS1994 iButton.

## Common using
WorkingMode global variable can take `READ` or `WRITE` value. (you'll have to rebuild solution)
* Setting `WRITE` switches to mode when you will be asked to enter new password, that hash will be written into button's memory. 
    After that [original vCard][1] file will be encrypted.
* In `READ` mode you will be asked to enter password. If it's hash mathes one in button's memory, [encrypted vCard][1] will be decrypted.

## vCard
Default file names (can be changed in `encryptor.cpp`):
* original vCard: **_visitka_original.dat_**
* encrypted vCard: **_visitka_encrypted.dat_**
* decrypted vCard: **_visitka_decrypted.dat_**

[1]: https://github.com/OlegBaslak/rfe-pasoib-ds1994/new/master?readme=1#vcard
