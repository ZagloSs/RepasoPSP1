Haz un cliente y un servidor (monocliente). El cliente envía mensajes al servidor con números enteros como cadenas (lectura por teclado). Si es un entero válido, el server los va acumulando. Y si no es válido, simplemente lo descarta. Cuando el cliente envía la cadena "FIN" (mayúsculas o minúsculas), el servidor le responde con el resultado de todos los enteros válidos acumulados y se cierra la conexión. El cliente muestra el resultado y termina. Para comprobar si una cadena es un entero o no, usa "Integer.parseInt(x)" sobre un try-catch. Si salta una excepción, la cadena no es un "int".