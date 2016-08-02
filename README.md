# FinalProject for GoJava courses

##General information

The topic of the project is *Luhn algorithm*, also known as the "modulus 10" or "mod 10" algorithm, and its implemetation in a simple Java program.
The algorithm is used to validate the card number, i.e. check whether the number of the plastic card can be used for issuance of this card; or whether the person has typed the number of his/her issued card correctly, e.g. in online banking system.
Possible types of the cards are (including but not limited): bank card, discount card, [IMEI number](http://www.imei.info/), [social security code](https://en.wikipedia.org/wiki/Social_Security_number), number of railway carriage.

##How the algorithm works
The algorithm calculates the sum of the numbers in a particular card:
- the numbers should be numerated from the end
- the ones that are in the odd places remain as they are
- the ones that are in the even places are doubled. If the result of multiplication is greater than 9 (nine), the numbers in the result are added. Example: 7 * 2 = 14; 14 > 9; result = 1 + 4 = 5;
- all the numbers are added and the sum is checked to be a multiple of 10 (ten). If the sum is multiple, then the card number is OK and can be used for issuance of a real card; otherwise it means that the person has typed the card number correctly. If it is not, the difference between the actual number and the nearest sum which is a multiple of 10 becomes the control number. Example: the sum is 50 -> the number is OK and the control sum is 0 (zero); the sum is 52 -> the control number is 2.
In the code there are two methods: one calculates the sum and the second one retrieves the control number from this sum.

##How the program works
The user is offered to select the card type and type in the card number, then the program calculates the sum and control number. The received data is saved in the object corresponding to the card type. These data are card type, its number, sum and control number, so each object contains the unique data about a particular selected card. 
If the customer selects the card type which is not covered in the program; or if the number of the card is incorrect (e.g. the correct amount of digits in bank card is 16), the user is offered to try once again.

###Links used to write the code:
- [Luhn Algorithm wiki (English)](https://en.wikipedia.org/wiki/Luhn_algorithm)
- [Luhn Algorithm wiki (Russian)](https://ru.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D0%9B%D1%83%D0%BD%D0%B0)
