#include <iostream>
#include <fstream>
#include <string>

using std::cin;
using std::cout;
using std::string;

class FileNotFoundException : public std::exception
{
	private:
		string msg;
		
	public:
		FileNotFoundException(string filename)
		{
			this->msg = "File '" + filename + "' was not found";
		}
		
		virtual const char* what() 
		{
			return this->msg.c_str();
		}
};

int main (int argc, char *argv[])
{
	std::ifstream input;
	std::ofstream output;
	
	string filename;
	string line;
	string data;
	int lineNumber = 1;
	
	cout << "Enter filename to read from: ";
	cin >> filename;
	
	try
	{
		// --- reading ---
		input.open(filename, std::fstream::in);
		if (input.fail())
		{
			throw FileNotFoundException(filename);
		}
		while(std::getline(input, line))
		{
			cout << "#" << lineNumber++ << "\t" << line << "\r\n";
		}
		input.close();
		// --- reading ---
		
		// --- writing ---
		cout << "Enter data to be written to the file: ";
		cin.ignore();
		std::getline(cin, data);
		cout << "Entered data is:'" << data << "'\n";
		
		output.open(filename, std::fstream::app);
		output << data;
		output.close();
		// --- writing ---
	}
	catch(FileNotFoundException& fex)
	{
		cout << "Exception caught " << fex.what() << "\n";
	}
	
	return 0;
}