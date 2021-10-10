class MyException: public std::exception
{
	public:
		virtual const char* what() const noexcept
		{
			return "User defined exception was thrown";
		}
};