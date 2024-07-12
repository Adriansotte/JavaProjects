import tkinter

ventana = tkinter.Tk()
ventana.geometry("500x500")

etiqueta = tkinter.Label(ventana, text = "Hola Mundo")
etiqueta.pack()

ventana.mainloop()