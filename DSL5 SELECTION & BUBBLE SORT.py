def array(A):
    n=int(input("Enter the total no. of students:"))
    
    for i in range(n):
        x=int(input("\n Enter the first year percentage  of student %d: " %(i+1)))
        A.append(x)
    print("\n student info accepted successfully\n")
    return n


def display(A):
    n=len(A)
    if(n==0):
        print("\n No records in the database")
    else:
        print("Students Array: ",end=' ')
        for i in range(n):
            print("%d" %A[i], end=' ')
    print(" ")
    
def Selection_sort(A):
    n=len(A)
    for i in range(n-1):
        min=i
        for j in range(i+1,n):
            if(A[j]<A[min]):
                min=j
        temp=A[i]
        A[i]=A[min]
        A[min]=temp
                
def bubble_sort(A):
    n=len(A)
    for i in range(1,n):
        for j in range(n-i):
            if(A[j]>A[j+1]):
                temp=A[j]
                A[j]=A[j+1]
                A[j+1]=temp
                
                
def main():
    A=[]
    while True:
        print("\n\t1 : Accept & display students FE marks")
        print("\t2 : Execure selection sort in Ascending order")
        print("\t3 : Execute bubble sort in Ascending order and Display top Five scores")
        print("\t4 : Exit")
        choice=int(input("\n Enter your choice:"))
        if(choice==4):
            print("End of program")
            quit()
            break
        elif(choice==1):
            A=[]
            array(A)
            display(A)
        elif(choice==2):
            print("Marks before sorting")
            display(A)
            Selection_sort(A)
            print("Marks after sorting")
            display(A)
        elif(choice==3):
            n=len(A)
            print("Marks before sorting")
            display(A)
            bubble_sort(A)
            print("Marks after sorting")
            display(A)
            if(len(A)>=5):
                print("Top Five Scores :")
                n=len(A)
                if(len(A)>=5):
                    B=[]
                    for i in range(n-5,n):
                        x=A[i]
                        B.append(x)
                    s=len(B)
                    m=int(s/2)
                    for j in range(m):
                        temp=B[j]
                        B[j]=B[s-j-1]
                        B[s-j-1]=temp
                    for j in range(s):
                        print("\t %.2f"%B[j])
            else:
                print("Top Five scores:")
                s=len(A)
                m=int(s/2)
                for j in range(m):
                    temp=A[j]
                    A[j]=A[s-j-1]
                    A[s-j-1]=temp
                for j in range(s):
                    print("\t %.2f"%A[j])

        else:
            print("Enter Enter correct choice choice")
main()