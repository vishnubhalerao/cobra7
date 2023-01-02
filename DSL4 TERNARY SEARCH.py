def accept_array(A):
    n = int(input("Enter the total number of the students :- "))
    print("Please input roll numbers in sorted order")
    for i in range(n):
      A.append(int(input()))
    print("Student Info collected successfully")
    return n


def display(A,n):
    if (n == 0):
        print("Data not found")
    else:
        print("Student array : ", end=" ")
        for i in range(n):
            print("%d"%A[i],end=' ')
        print("\n")


def ternary_search(A, l, r, key):
    if (r >= 1):
        mid1 = l + int((r - l) / 3)
        mid2 = r - int((r - l) / 3)
        if (A[mid1] == key):
            return mid1
        if (A[mid2] == key):
            return mid2
        if (key < A[mid1]):
            return ternary_search(A, l, mid1 - 1, key)
        elif (key > A[mid2]):
            return ternary_search(A, mid2 + 1, r, key)
        else:
            return ternary_search(A, mid1 + 1, mid2 - 1, key)
    return -1


def main():
    A = []
    while True:
        print(" 1 : Accept and display Student Info ")
        print(" 2 : Execute Ternary Search ")
        print(" 3 : EXIT ")
        ch = int(input("Enter your choice : "))
        if (ch == 3):
            print("End of the Program ")
            quit()
        elif (ch == 1):
            A = []
            n = accept_array(A)
            display(A, n)
        elif (ch == 2):
            X = int(input("Please enter the roll number which you want to search : "))
            flag = ternary_search(A, 0, n-1, X)
            if (flag == -1):
                print(X, "Roll no. is not a member of the club")
            else:
                print(X, "Roll no. is a member of the club stored at the location ", flag + 1)
        else:
            print("Please enter the correct choice")


main()

