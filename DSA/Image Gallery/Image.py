from tkinter import *
from PIL import ImageTk,Image
root = Tk()
root.title('Enjoy with Tkinter')
#root.iconbitmap('C:/Users/hp1/Desktop/work/i.jpg')

my_img1 = ImageTk.PhotoImage(Image.open("Photo/a.jpg"))
my_img2 = ImageTk.PhotoImage(Image.open("Photo/i.jpg"))
my_img3 = ImageTk.PhotoImage(Image.open("Photo/facebook.png"))
my_img4 = ImageTk.PhotoImage(Image.open("Photo/gmail.jpg"))
my_img5 = ImageTk.PhotoImage(Image.open("Photo/linkedin.png"))
my_img6 = ImageTk.PhotoImage(Image.open("Photo/pinstars.png"))
my_img7 = ImageTk.PhotoImage(Image.open("Photo/twitter.png"))
my_img8 = ImageTk.PhotoImage(Image.open("Photo/utube.png"))


my_list = [my_img1,my_img2,my_img3,my_img4,my_img5,my_img6,my_img7,my_img8]

l = Label(image=my_img1)
l.grid(row=0,column=0,columnspan=3)


def forward(image_number):
    global l
    global button_forward
    global button_back

    l.grid_forget()
    l = Label(image=my_list[image_number-1])
    button_forward = Button(root,text=">>",command=lambda:forward(image_number+1))
    button_back = Button(root,text="<<",command=lambda:back(image_number-1))

    if image_number==8:
         button_forward = Button(root,text=">>",state=DISABLED)
   

    l.grid(row=0,column=0,columnspan=3)
    button_back.grid(row=1,column=0)
    button_forward.grid(row=1,column=2)


def back(image_number):
    global l
    global button_forward
    global button_back


    

    l.grid_forget()
    l = Label(image=my_list[image_number-1])
    button_forward = Button(root,text=">>",command=lambda:forward(image_number+1))
    button_back = Button(root,text="<<",command=lambda:back(image_number-1))

    if image_number==1:
        button_back = Button(root,text="<<",state=DISABLED)
   

    l.grid(row=0,column=0,columnspan=3)
    button_back.grid(row=1,column=0)
    button_forward.grid(row=1,column=2)


button_back = Button(root,text="<<",command=back)
button_exit = Button(root,text="Exit Program",command=root.quit)
button_forward = Button(root,text=">>",command=lambda:forward(2))
button_back.grid(row=1,column=0)
button_exit.grid(row=1,column=1)
button_forward.grid(row=1,column=2)



root.mainloop()