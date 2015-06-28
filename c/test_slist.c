#include <stdio.h>
#include <sys/queue.h>
#include <stdlib.h>

struct numbers {
    int n;

    SLIST_ENTRY (numbers) entries;
};

SLIST_HEAD(HEADNAME, numbers) head = SLIST_HEAD_INITIALIZER(head);

void print(void *x)
{
    printf("mhv");
}

int main()
{
    int i;
    struct numbers *temp, *temp1;
    print(NULL);
    for(i = 1; i <= 10; i++) {
        struct numbers num;
        temp = malloc (sizeof(struct numbers));
//        temp = NULL;
        SLIST_INSERT_HEAD(&head, temp, entries);
        temp->n = i;
        printf("\n%d", temp->n);
       // temp = NULL;
    }

    SLIST_FOREACH_SAFE(temp, &head, entries, temp1) {
        printf("\nInside foreach");
        printf("\t%d", temp->n);
        SLIST_REMOVE(&head, temp, numbers, entries);
        
/*   
        if (temp->n == 5) {
            SLIST_REMOVE_HEAD(&head, entries);
            SLIST_REMOVE(&head, temp, numbers, entries);
            SLIST_REMOVE_HEAD(&head, entries);
            free(temp);
            temp = temp1;
        }
*/
        temp = NULL;
    }

    while (!(SLIST_EMPTY(&head))) {
        printf("\n%d", temp->n );
        printf("\nInside list_empt1y");
        temp = SLIST_FIRST(&head);
        SLIST_REMOVE_HEAD(&head, entries);
        free(temp);
    }
}
