default_pass = "admin"

print("Choose an option:")
print("1. Check default password")
print("2. Show password in stars")
print("3. Check if password contains only letters")

try:
    opt = int(input("Enter option (1-3): "))
    password = input("Enter password: ")

    if opt == 1:
        if password == default_pass:
            print("This is the default password!")
            password = input("Enter a new password: ")
        else:
            print("This is not a default password.")

    elif opt == 2:
        print("Password in stars:", "*" * len(password))
        print("Actual password:", password)

    elif opt == 3:
        if password.isalpha():
            print("Password contains only letters.")
            password = input("Re-enter a new password with numbers: ")
        else:
            print("Password is alphanumeric.")

    else:
        print("Invalid option. Choose 1, 2, or 3.")

except ValueError:
    print("Please enter a valid number.")
