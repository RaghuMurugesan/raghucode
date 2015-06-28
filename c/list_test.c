#include <stdio.h>
#include <sys/queue.h>
#include <stdlib.h>

struct numbers {
    int n;

    SLIST_ENTRY (numbers) entries;
};

SLIST_HEAD(HEADNAME, numbers) head = SLIST_HEAD_INITIALIZER(head);

int main()
{
    int i;
    struct numbers *temp, *temp1;
    for(i = 1; i <= 10; i++) {
        struct numbers num;
        temp = malloc (sizeof(struct numbers));
        SLIST_INSERT_HEAD(&head, temp, entries);
        temp->n = i;
        temp = NULL;
    }

    SLIST_FOREACH_SAFE(temp, &head, entries, temp1) {
        printf("\tInside foreach");
        printf("\n%d and %d", temp->n, temp1->n );
       // SLIST_REMOVE(&head, temp, numbers, entries);
   
        if (temp->n == 5) {
        SLIST_REMOVE_HEAD(&head, entries);
//            SLIST_REMOVE(&head, temp, numbers, entries);
        }
 //       SLIST_REMOVE_HEAD(&head, entries);
        free(temp);
        temp = temp1;
    }

    while (!(SLIST_EMPTY(&head))) {
        printf("\n%d", temp->n );
//      printf("\nInside list_empt1y");
//        temp = SLIST_FIRST(&head);
 //       SLIST_REMOVE_HEAD(&head, entries);
  //      free(temp);
    }
/*    while (!(SLIST_EMPTY(&head))) {
        printf("\n%d", temp->n );
        printf("\nInside list_empty");
        temp = SLIST_FIRST(&head);
        SLIST_REMOVE_HEAD(&head, entries);
        free(temp);
    }
    //printf("%d",a);
*/
}
