import getpass

def caesar_encrypt(text, shift):
    result = ""
    for char in text:
        if char.isalpha():
            base = ord('A') if char.isupper() else ord('a')
            result += chr((ord(char) - base + shift) % 26 + base)
        else:
            result += char  # Leave digits, symbols, etc.
    return result

print("=== Caesar Cipher Password Encryption ===")

# Get password securely
password = getpass.getpass("Enter your password (input hidden): ")

# Get shift value from user
try:
    shift_value = int(input("Enter the shift value: "))
    encrypted_password = caesar_encrypt(password, shift_value)
    print(f"Encrypted password (Caesar cipher): {encrypted_password}")
except ValueError:
    print("Please enter a valid integer for the shift.")
