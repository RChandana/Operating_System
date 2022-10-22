#include<stdio.h>
int main(){
    int ms, ps, nop, np, rempages, i, j, x, y, pa, offset;
    int s[10], fno[10][20];
    clrscr();
    printf("\nEnter the memory size -- ");
    scanf("%d",&ms);

    printf("\nEnter the page size -- ");
    scanf("%d", &ps);

    nop = ms/ps;
    printf("\nThe no. of pages available in memory are -- %d ", nop);
    printf("\nEnter number of processes -- ");
    scanf("%d", &np);
