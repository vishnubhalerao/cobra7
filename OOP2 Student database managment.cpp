#include<iostream>
#include<string>
using namespace std;
class student
{
	string name,clas,dob,blood_grp,addr,lic; 
	int *rollno,div,mob;
	public:
		friend class teacher;
	student()
	{
		//pointer_variable = new data_type
		rollno=new int;
		name,clas,dob,blood_grp,addr,lic="";
		*rollno,div,mob=0;
	}
	student(student &obj)       //s[0]. name=abc s[1]=abc   obj=s1
	{
		this->name=obj.name;			//this is a pointer points to the object which invokes it
      this->addr=obj.addr;	//this-> can be written as name
      this->clas=obj.clas;
      this->div=obj.div;
      this->rollno=obj.rollno;
      this->mob=obj.mob;
      this->blood_grp=obj.blood_grp;
      this->dob=obj.dob;
	}
	~student()
	{
		delete rollno;
	}

	inline static void display_header()
	{
		cout<<"\n ----------------- Student information system-------------------";
		cout<<"\n name \t rollno \t division \t class \t dateofbirth \t mobile \t blood group \t address \t license numbr";
	}
	void getdata()
	{
		cout<<"\n Enter rollno";
		cin>>*rollno;
		cout<<"\n Enter name";
		cin.ignore();   ///clear the buffer/stream
		getline(cin,name);
		cout<<"\n Enter dividion";
		cin>>div;
		cout<<"\n enter mob";
		cin>>mob;
		cout<<"\n enter class,date of birth, blood group,address,license number ";
		cin>>clas>>dob>>blood_grp>>addr>>lic;
	}
	void display()
	{
		
		cout<<"\n"<<name<<"\t"<<*rollno<<"\t"<<div<<"\t"<<clas<<"\t"<<dob<<"\t"<<mob<<"\t"<<blood_grp<<"\t"<<addr<<"\t"<<lic;
	}
	
};
class teacher
{
	int id;
	public:    
		teacher()
		{
			id=0;
		}
		void display_t(student &obj1,int t_d)   //(s[0],3)  s[1],3
		{
		try
		{
			if(obj1.div==t_d) //s[0].div==3   3==3   s[1].div ==3 2==3
			obj1.display();
			else
			throw(obj1.div);
			}
			catch(int x)  //x=2
			{
				cout<<"student & teacher division can not matched";
				}	
		}
		
};
int main()
{
	 student s[10];
	 teacher t;
	 int ch,count=0;
	 do
	 {
	 
	 cout<<"\n --------------------- Student information system ----------------------";
	 cout<<"\n -------------------- Menu------------------------";
	 cout<<"\n 1. add student record";
	 cout<<"\n 2. Display student record";
	 cout<<"\n 3. Copy constructor";
	 cout<<"\n 4. Divison wise information";
	 cout<<"\n 5. Exit";
	 cout<<"\n Enter choice";
	 cin>>ch;
	 switch(ch)
	 {
	 	case 1:
	 		s[count].getdata();   //s[0].getdata()  s[1].getdat()
	 		count++;
	 		break;
	 	case 2:
	 		student::display_header();
		   for(int i=0;i<count;i++)
		   {
		   	s[i].display();
			   	
	       }
		   break;
		case 3:
			{
			cout<<"\n copy constructor";
			student s1;
			s1.getdata();
			student s2(s1);
			s2.display();
		
		}
		break;
		case 4:
			int t_div;
			cout<<"\n Enter division";
			cin>>t_div;
			for(int i=0;i<count;i++)
			{
				t.display_t(s[i],t_div);   //s[1],3
			}
			break;
		case 5:
		 exit(0);     
}
}while(ch!=5);
return 0;
}
