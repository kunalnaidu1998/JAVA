// File: assignment-1.s
// Aurthor: Kunal Naidu
// Date: September 23, 2021
//
//Description:
// Calculates the value maximum value of y = -3x^4+ 267x^2+ 47x-43

                .data
maxValueOutput: .string         "The Maximum value is %d, %d\n" //create string variable

                .balign         4                               // are divisible by 4 as all the addresses should be aligned with 
                                                                // the word length of the machine


                .global         main                            // this here is a pseudo op which sets the start label to main
main:
                stp     x29, x30, [sp, -16]!                    // store the FP and LP to stack in stack with two double space
                mov     x29, sp                                 // move the SP to the FP

                mov     x25, 0                                  // initialize maximum value 
                mov     x19, -10                                // initialize variable for loop on x19 
                b loop_test                                     // branch to the test

loop_top:

                mov     x20, -3                                 // initialize first term with value -3 on x20
                mul     x20, x20, x19                           // multiply x20 by x19 and store on x20
                mul     x20, x20, x19                           // multiply x20 by x19 and store on x20
                mul     x20, x20, x19                           // multiply x20 by x19 and store on x20
                mul     x20, x20, x19                           // multiply x20 by x19 and store on x20

                mov     x21, 267                                // initialize second term with value 267 on x21
                mul     x21, x21, x19                           // multiply x21 by x19 and store on x21
                mul     x21, x21, x19                           // multiply x21 by x19 and store on x21

                mov     x22, 47                                 // initialize third term with value 47 on x22
                mul     x22, x22, x19                           // multiply x22 by x19 and store on x22

                mov     x23, -43                                // initialize fourth term with value -43 on x23

                mov     x24, 0                                  // initialize sum with 0 on x24
                add     x24, x20, x24                           // add x20 to x24 and store it on x24
                add     x24, x21, x24                           // add x21 to x24 and store it on x24
                add     x24, x22, x24                           // add x22 to x24 and store it on x24
                add     x24, x23, x24                           // add x23 to x24 and store it on x24

                cmp     x24, x25                                // compares x25 with x24 to determine maximum value
                b.le    display                                 // if x24 <= x25 then branch to display
                mov     x25, x24                                // move x24 to x25


display:
                ldr     x0, =maxValueOutput                     // load output string for maxValueOutput into register x0
                mov     x1, x19                                 // move looper value into x1
                mov     x2, x25                                 // move max value into x2
                bl      printf                                  // print


                add     x19, x19, 1                             // step to the next value in loop

loop_test:
                cmp x19, 10                                     // x19<10?
                b.lt loop_top                                   // if so, loop

exit:
                ldp x29, x30, [sp], 16                          // restore state and deallocate memory in RAM
                ret                                             // return