import math

def encrypt(plain_text, keyword):
    plain_text = plain_text.upper()
    keyword = keyword.upper()
    key_length = len(keyword)
    num_rows = math.ceil(len(plain_text) / key_length)

    # Fill the grid row by row
    grid = [['_' for _ in range(key_length)] for _ in range(num_rows)]
    index = 0
    for r in range(num_rows):
        for c in range(key_length):
            if index < len(plain_text):
                grid[r][c] = plain_text[index]
                index += 1

    # Determine column order
    order = sorted(range(len(keyword)), key=lambda x: keyword[x])

    # Read by columns
    cipher_text = ''.join(grid[r][i] for i in order for r in range(num_rows))
    return cipher_text

def decrypt(cipher_text, keyword):
    keyword = keyword.upper()
    key_length = len(keyword)
    num_rows = math.ceil(len(cipher_text) / key_length)

    # Fill column-wise based on keyword order
    order = sorted(range(len(keyword)), key=lambda x: keyword[x])
    grid = [['' for _ in range(key_length)] for _ in range(num_rows)]

    index = 0
    for i in order:
        for r in range(num_rows):
            if index < len(cipher_text):
                grid[r][i] = cipher_text[index]
                index += 1

    # Read row-wise
    plain_text = ''.join(grid[r][c] for r in range(num_rows) for c in range(key_length))
    return plain_text.replace('_', '')

# Main logic
plain = input("Enter the plain text: ").upper()
key = input("Enter the keyword: ").upper()

cipher = encrypt(plain, key)
print("Cipher Text:", cipher)

decrypted = decrypt(cipher, key)
print("Decrypted Text:", decrypted)
