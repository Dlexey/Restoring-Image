Алексей Дубровинский
alexey.dubrovinskiy@rambler.ru
17 октября 2017


Программа ImageClear.jar восстанавливает участки фотографии по фотографии меньшего размера.
Автор столкнулся с ситуацией, когда есть фотография большого разрешения, но на неё нанесён текст и есть другая такая же
фоторгафия, но гораздо меньшего разрешения.



В одной папке с ImageClear.jar должен присутствовать входной файл типа in.jpg (фотография, которую будут восстанавливать)
или любого другого формата. Входной файл типа in.jpg должен быть в единственном экземпляре.

Так же должен присутствовать  файл color_mask.jpg (фотография меньшего разрешения, из которой будут браться цвета для
восстановления изображения)  или любого другого формата.

Границы восстанавливаемых участков прописываются в файле bounds.txt в следующем формате: 


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


где для верхней строки 217,645 - координаты верхнего левого угла первого участка, через двоеточие 233,689 - координаты
нижнего правого угла участка. И на следующех строках координаты следующих участков.


После работы программы в папке должен будет появиться файл out.png с восстановленным изображением.
