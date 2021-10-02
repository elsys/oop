class Point
{
	private:
		int x, y;
	public:
		Point();
		Point(int x, int y);
			
		void set(int x, int y);
		int getx();
		int gety();
		void move(int dx, int dy);
		void print();
}; 
