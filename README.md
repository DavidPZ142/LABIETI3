# LABIETI3

## David Pérez Mejia

## Part I
**Despues de añadir la configuración revisamos los endpoints que estan abiertos para todo el mundo**
![](https://github.com/DavidPZ666/LABIETI3/blob/master/img/openendpoint.jpg)
**Y vemos que no nos pone ningun problema** 

**A diferencia de los endpoints que no hemos definido abiertos**
![](https://github.com/DavidPZ666/LABIETI3/blob/master/img/unopenendpoint.jpg)
**Nos pone un 403 forbidden**

## Part II

**Probamos como nos guarda las contraseñas**
![](https://github.com/DavidPZ666/LABIETI3/blob/master/img/probandoClave1.jpg)
![](https://github.com/DavidPZ666/LABIETI3/blob/master/img/probandoClave2.jpg)
**Vemos como en database nos la guarda seguro**

### Probamos el login 

**Nos genera el token con su fecha de expedicion**
![](https://github.com/DavidPZ666/LABIETI3/blob/master/img/login1.jpg)

**Si la clave es incorrecta lanza la excepcion**
![](https://github.com/DavidPZ666/LABIETI3/blob/master/img/login2.jpg)


## Part III

**Hacemos login con un usuario con el rol de USER**
![](https://github.com/DavidPZ666/LABIETI3/blob/master/img/partIII1.jpg)

**Posteriormente con el token podemos ingresar a los endpoints**
![](https://github.com/DavidPZ666/LABIETI3/blob/master/img/partIII2.jpg)
