# Restoring-Image
Restoring a part of a photo using the same photo of a smaller resolution.

In one folder with ImageClear.jar there should be an input file of type in.jpg (the photo to be restored) or any other format. The input file of type in.jpg must be in a single copy.

Also there should be a file color_mask.jpg (a photo of a smaller resolution, from which colors will be taken to restore the image) or any other format.

The boundaries of the recoverable areas are written in the bounds.txt file in the following format:


217,645:233,689

234,643:296,692
296,646:358,689
359,645:375,689
376,645:440,689
441,647:504,689
505,645:521,689
522,646:584,689
584,643:645,690
646,675:662,689
663,644:724,690
725,645:786,689


where for the top line 217,645 - the coordinates of the upper left corner of the first section, through the colon 233,689 - the coordinates of the lower right corner of the section. And on the next lines the coordinates of the following sections.


After the program has run, a file called out.png with the restored image will appear in the folder. 
