#include <string>
#include <vector>
#include <sstream> //istringstream
#include <iostream> // cout
#include <fstream> // ifstream
#include <cstring>

 
using namespace std;
 
/**
 * Reads csv file into table, exported as a vector of vector of strings.
 * @param inputFileName input file name (full path).
 * @return data as vector of vector of strings.
 */


int counter =0;

void total_cases(vector<vector<string>> data,int l,ofstream &MyFile){

    string total_cases="";
    string country="";
    total_cases = data[1][4];
    country = data[1][2];
    //cout<<before;
    
        for (int i=1 ;i<l;i++){

            
            if(data[i][4] >= total_cases.c_str() ){
              total_cases = data[i][4] ; 
              


            }

            if(data[i][2] != country.c_str()){

                     MyFile<< "total cases: "<<" "<< total_cases << "    "<<"country: " << country<<endl;
                     total_cases="0";
                     country=data[i][2];

            }

            //before=data[i][2];
            //cout<< before.c_str()<<country.c_str();
            
        }

    
}



void earliest_date(vector<vector<string>> data,int l,ofstream &MyFile){

    string before="";
    string country="";
    before = data[0][3];
    
        for (int i=0 ;i<l;i++){
            
            if(data[i][3] < before.c_str()){
              before = data[i][3] ;
              country = data[i][2];
            }

            //before=data[i][2];
            //cout<< before.c_str()<<country.c_str();
            
        }

    MyFile<< "date and country : "<< before << country<<endl;
}
int country_counter(vector<vector<string>> data,int l){
    string before="";
    
        for (int i=0 ;i<l;i++){
            //cout<< data[l][2] <<" " <<counter << endl;
            if(data[i][2] != before.c_str())
              counter++;

            before=data[i][2];
            
        }
    return counter;

}

vector<vector<string>> parse2DCsvFile(string inputFileName) {
 
    vector<vector<string> > data;
    ifstream inputFile(inputFileName);
    int l = 0;
 
    while (inputFile) {
        l++;    
        string s;
        if (!getline(inputFile, s)) break;
        if (s[0] != '#') {
            istringstream ss(s);
            vector<string> record;
 
            while (ss) {
                string line;
                if (!getline(ss, line, ','))
                    break;
                try {
                    record.push_back(line);
                }
                catch (const std::invalid_argument e) {
                    cout << "NaN found in file " << inputFileName << " line " << l
                         << endl;
                    e.what();
                }
            }
 
            data.push_back(record);
        }
    }
    
    if (!inputFile.eof()) {
        cerr << "Could not read file " << inputFileName << "\n";
        __throw_invalid_argument("File not found.");
    }
 
    return data;
}
 
int main()
{
    vector<vector<string>> data = parse2DCsvFile("owid-covid-data.csv");

// Create and open a text file
  ofstream MyFile("output.txt");

  int l=83657;
  // Write to the file
  MyFile << "Files can be tricky, but it is fun enough!"<<endl;

  
  MyFile<< "countries num: "<< country_counter(data,l)<<endl;

  earliest_date(data,l,MyFile);

  total_cases(data,l,MyFile);

  
    #if 0
    for (auto l : data) {
        for (auto x : l)
            
        MyFile << x <<" " << endl;
    }
 
    #endif

  // Close the file
  MyFile.close(); 

    return 0;
}