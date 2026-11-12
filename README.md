Creé el enum Zona con las tarifas y el orden de ruta, y la clase abstracta Paquete con atributos final de la que heredan PaqueteEstandar, PaqueteExpress y PaqueteFragil (este último implementa ManejoEspecial para las advertencias)
Con ValidadorPaquete reviso guías y pesos lanzando excepciones personalizadas para no detener el programa
En Despacho genero el código static, controlo duplicados con equals y el límite de 30 kg, ordeno con Comparable y saco advertencias con instanceof

Principios SOLID
Abierto/Cerrado: En Paquete, sus clases hijas, ManejoEspecial y Despacho, porque se pueden agregar servicios nuevos creando otra clase hija sin modificar lo que ya existe
Responsabilidad Única: En ValidadorPaquete, Paquete y Despacho, ya que cada clase se encarga de una sola cosa 
