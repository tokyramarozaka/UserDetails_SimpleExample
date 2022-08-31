# UserDetails_SimpleExample
Just a very barebone basic structure for those who wish to have a different provider in Spring Security. 

The main highlights of this app lies in the `security` package.

Please note that this is NOT meant to showcase the optimal configuration in terms of security.
Rather, its goal is to to give a starting point for those who want to configure a different provider.

# Using the application
To use the application, make sure you have PostgreSQL installed, and that you have created an empty database called `test_hibernate`. You can change the settings in the application.properties file, if you want to configure the database.

Then, create some users in the `user` table, by default all user accounts are set to be enabled. Changing this will not influence how the authentication procedure at the time of writing.

