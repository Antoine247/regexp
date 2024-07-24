## Parser de anatomia patologica

parser que se encarga de leer patrones de texto y formato para tomar los valores importantes y ordenarlos adecuadamente

## Uso

solo es necesario pasar al programa un string con el directorio donde estan los txt a formatear, el programa leera TODOS
los txt del directorio

uso en CLI con el jar dentro de la carpeta con los txt

     java -jar anatpatparser.jar "./"

si hay problemas con el funcionamiento del jar, enviarle otro argumento con el numero 1 va a activar el logger, este se imprimira donde este el jar

     java -jar anatpatparser.jar "./" "1"

