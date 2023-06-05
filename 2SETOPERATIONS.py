size=int(input("enter size of first list "))
size1=int(input("enter size of second list "))
print("enter element of set 1 ")
list1=[]
for i in range(size):
    element=int(input("enter element: "))
    list1.append(element)
    choice=0
while choice !=10:
    print("|-------------------|")
    print("Menu")
    print("1.add")
    print("2.remove")
    print("3.contains")
    print("4.size")
    print("5.intersection")
    print("6.union")
    print("7.difference")
    print("8.subset")
    print("9.proper subset")
    print("10.exit")
    print("|-------------------|")
    choice=int(input("enter choice "))
    if choice==1:
        e=int(input("enter number to add "))
        list1.append(e)
        print(list1)
    elif choice==2:
        e=int(input("enter a number to remove "))
        list1.remove(e)
        print(list1)
    elif choice==3:
        e=int(input("enter number to search "))
        if e in list1:
             print("number is present in set->",e)
        else:
            print("number is not present in set")
            print(list1)
    elif choice==4:
        print("set contains ",{len(list1)}, "elements")
    elif choice==5:
        print("create a set 2 for doing intersection operation")
        print("data of set 2")
        list2=[]
        list3=[]
        for i in range(size1):
            element=int(input("enter element"))
            list2.append(element)
        for element in list1:
            if element in list2:
                list3.append(element)
        print("set 1=",list1)
        print("set2=",list2)
        print("intersection=",list3)
    elif choice==6:
        print("create set 2 for doing union operation")
        print("data of set 2")
        list2=[]
        list3=[]
        for i in range(size1):
            element=int(input("enter element"))
            list2.append(element)
            list1=list1.copy()
        for element in list2:
            if element not in list1:
                list3.append(element)
        print("set 1 =",list1)
        print("set 2 =",list2)
        print("union =",list3)
    elif choice==7:
        print("create a set 2 for doing diff")
        print("data of set 2")
        list2=[]
        list3=[]
        for i in range(size1):
            element=int(input("enter element"))
            list2.append(element)
        for element in list1:
            if element not in list2:
                list3.append(element)
        print("set 1=",list1)
        print("set 2=",list2)
        print("set 1-set2=",list3)
    elif choice==8:
        print("checking subset or not")
        list2=[]
        list3=[]
        for i in range(size1):
            element=int(input("enter element"))
            list2.append(element)
        for element in list1:
            if element not in list2:
                print("set 2 is not the subset of set 1")
            else:
                print("set 2 is subset of set 1")
    elif choice==9:
        list2=[]
        list3=[]
        for i in range(size1):
            ele=int(input("enter element"))
            list2.append(ele)
        for element in list2:
            if element in list1:
                list3.append(element)
                print("set b is proper subset of set a")
            else:
                print("set b is not proper subset of set a")
    elif choice==10:
        break
    elif choice <1 or choice >10:
        print("enter valid choice!!!")
