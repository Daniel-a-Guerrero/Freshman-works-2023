#include <iostream>

using namespace std;

int main()
{
    string fn,ln;
    int csNum;
    cout << "Please enter your first name >>" << endl;
    cin>>fn;
    cout << "Please enter your last name >>" << endl;
    cin>>ln;
    cout << "Please enter your CS 280 section number >>" << endl;
    cin>>csNum;
    cout<<"Hello "<<fn<<", welcome to CS 280 section "<<csNum;
    return 0;
}
