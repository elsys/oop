#include <stdio.h>
#include <stdlib.h>

// https://medium.com/@laura.derohan/compiling-c-files-with-gcc-step-by-step-8e78318052
// https://devblogs.microsoft.com/oldnewthing/20080926-00/?p=20743
int WritToFile(int number)
{
	int code;
	FILE *fptr;
	fptr = fopen("", "w");
	if(fptr == NULL)
	{
		printf("Error!\n");
		code = 1;
	}
	else
	{
		fprintf(fptr, "%d", number);
		fclose(fptr);
		code = 0;
	}
	return code;
}

int main()
{
	int num;

	printf("Enter num: ");
	scanf("%d",&num);
	int returnCode = WritToFile(num);
	printf("Return code: %d\n", returnCode);

	// how to get the error code:
	// linux - echo $?
	// win - echo %errorlevel%
	return returnCode;
}
