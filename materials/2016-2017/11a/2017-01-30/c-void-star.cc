#include <iostream>

void copyint(int* src, int* dest, int size) {
	for (int i = 0; i < size; i++) {
		dest[i] = src[i];
	}
}

void copy(void* src, void* dest, int byte_size) {
	for (int i = 0; i < byte_size; i++) {
		static_cast<char*> (dest)[i] = static_cast<char*> (src)[i];
	}
}

int main() {
	int a[] = { 0, 1, 4, 9, 11};
	int b[4];
	double c[] = {0.1, 0.3, -0.4, 0.8};
	double d[4];

	copy(a, b, sizeof(b));
	copy(c, d, sizeof(d));

	for (int i = 0; i < 4; i++) {
		std::cout << b[i] << " " << d[i] << " ";
	}
	std::cout << std::endl;
}

