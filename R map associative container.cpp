#include<iostream>
#include<map>
#include<string>
using namespace std;
int main()
{
	typedef map<string,int> maptype;
	maptype populationmap;
	populationmap.insert(pair<string,int>("maharashtra",7698754));
	populationmap.insert(pair<string,int>("punjab",6945753));
	populationmap.insert(pair<string,int>("west bengal",4564654));
	populationmap.insert(pair<string,int>("karnataka",6456663));
	populationmap.insert(pair<string,int>("kerela",4645346));
	populationmap.insert(pair<string,int>("rajasthan",5764535));
	populationmap.insert(pair<string,int>("uttar pradesh",6545343));
	maptype::iterator iter;
	cout<<"________Population of states in India___________";
	cout<<"\n size of population map"<<populationmap.size()<<endl;
	string state_name;
	cout<<"\n enter name of the state:";
	cin>>state_name;
	iter=populationmap.find(state_name);
	if(iter!=populationmap.end())
	cout<<state_name<<" 's population is"<<iter->second;
	else
	cout<<" \n key is not population"<<endl;
	populationmap.clear();
}
