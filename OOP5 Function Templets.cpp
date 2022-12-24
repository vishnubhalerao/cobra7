#include<iostream>
using namespace std;
template<class T>
class sort
{
	T a[50];
	int n;
	public:
		void accept()
		{
			cout<<"\n Enter no. of elements in an array";
			cin>>n;
			cout<<"\n Enter elements in an array";
			for(int i=0;i<n;i++)
			cin>>a[i];
		}
	    void ssort()
		{
			for(int i=0;i<n;i++)
			{
			   int min=i;
			   for(int j=i+1;j<n;j++)
			   {
			   	if(a[min]>a[j])
			   	min=j;
			   }
			   	T temp;
			   	temp=a[min];
			   	a[min]=a[i];
			   	a[i]=temp;
			}
	}
	void display()
	{
		for(int i=0;i<n;i++)
		cout<<"\n"<<a[i];
	}
};
int main()
{
	sort <int> s1;
	sort <float> s2;
	int ch;
	do
	{
		cout<<"\n Selection sort";
		cout<<"\n ------------Menus--------";
		cout<<"\n 1. Sorting of integer array";
		cout<<"\n 2. Sorting of float array";
		cout<<"\n 3. Exit";
		cout<<"\n Enter choice";
		cin>>ch;
		switch(ch)
		{
			case 1:
				s1.accept();
				cout<<"\n Array before sorting";
				s1.display();
				s1.ssort();
				cout<<"\n Array after sortng";
				s1.display();
				break;
			case 2:
				s2.accept();
				cout<<"\n Array before sorting";
				s2.display();
				s2.ssort();
				cout<<"\n Array after sortng";
				s2.display();
				break;
			case 3:
				exit(0);
		}
	}while(ch!=3);
	return 0;
}

