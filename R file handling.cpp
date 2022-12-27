#include<iostream>
#include<fstream>
using namespace std;
class student
{
	public:
		string name;
		int rollno;
		void getdata()
		{
			cout<<"\n Enter the name of student:";
			cin>>name;
			cout<<"\n Enter the roll no of student:";
			cin>>rollno;
		}
		void setdata()
		{
			cout<<"\n The name of student is:"<<name<<"\n The roll no of student is:"<<rollno;
		}
};
int main()
{
	student s;
	fstream f;
	f.open("student.txt",ios::out);
	s.getdata();
	f.write((char*)&s,sizeof s);
	f.close();
	f.open("student.txt",ios::in);
	s.setdata();
	f.read((char*)&s,sizeof s);
	f.close();
	return 0;
}
