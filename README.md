# <h1 align="center">Proyecto_Camisetas_L_A</h1>
---
<h1>Integrantes:</h1>

- <h4>Iván Manuel Anaya Ramos</h4>
- <h4>Juan Elías López Espitia</h4>

# Manual de Usuario
---
### Vista del Login.

En la siguiente vista se podrá apreciar lo que sería el login, se debe llenar los campos para iniciar la sesión, en caso de que no tenga un usuario registrado puede dirigirse hasta el apartado de registro, si preciona el botón "Registrarse" que se encuentra ubicada el la parte media de la pantalla después del botón iniciar sesión ( Login ): ![image](https://github.com/user-attachments/assets/eda96c55-6774-4045-b1e2-f26cb95d1705)


![image](https://github.com/user-attachments/assets/e8c37262-5c53-4202-aa23-44af4963bed2)

---
### Apartado de registro.

En esta vista te encontrarás con los campos correspondientes para la creacion de un nuevo usuario para el programa, debes asegurarte de que los datos estén ubicados correctamente y que el dato realmente corresponda a la información solicitada para que no ocurranigún error a la hora de crear el usuario.

![image](https://github.com/user-attachments/assets/b66f8e1c-d115-4a14-b7ec-68b2f12a8ab9)

---
### Vista Principal.

Esta es la vista donde el usuario podrá ingresar despues de llenar sus datos de incio, tendrá una variedad de opciones muy buena esto relacionado con la compra de camisetas buenas, bonitas y baratas :).

![image](https://github.com/user-attachments/assets/c5fa5831-a397-4b34-a315-2889910be367)

---
### Apartado de detalles.

En este apartado puede ver más información sobre la camiseta, selecionar una talla para luego así mandar la camiseta a la Bolsa de compras o al panel de deseados.

![image](https://github.com/user-attachments/assets/dd12c38b-ce69-4aef-b612-1d532ed03797)

---
### Apartado de deseos.

En el este apartado podrás gestionar tus camisetas preferidas o que quisieras comprar desde este apratado tendrás la opción de enviar la camiseta al panel de la bolsa de compras o eliminar directamente esa eleccion.

![image](https://github.com/user-attachments/assets/352965bf-e71f-4156-bda7-86553b5627b6)

---
### Apartado de la Bolsa de compras

En este panel podrás efectuar o hacer valida tu compra, el contador de las camisetas se inicia en 0 para que calcules cuantas son de tu preferencia comprar, en la siguiente imagen se muestra una camiseta antes de ser comprada.

![image](https://github.com/user-attachments/assets/d69cca73-81ae-4517-9c79-eb6ea589dfe5)

## Guia para Desarrollador:

Acontinuación tenemos la explicación o la demostración de de la solucion en el codigo fuente(Contenido para desarrolladores).

<table align="center">
  <tr>
          <h3 align="center">Tabla de Clases Relevantes</t3>
  </tr>
  <tr>
          <th>Clases</th>
          <th>Descripción</th>
  </tr>
  <tr>
          <td>Main.java</td>
          <td>Esta clase se encaraga de tomar el FXML de la pagina que se iniciará cuando se ejecute el programa carga la vista y lanza la aplicación</td>
  </tr>
  <tr>
          <td>Gestor.java</td>
          <td>Esta clase implementa el patrón de diseño singleton y gestiona las instancias de los modelos de datos</td>
  </tr>
  <tr>
          <td>ListaUsuarios.java</td>
          <td>Esta clase implementa los metodos para almacenar y gestionar usuarios, guarda estos en archivos.txt para la persistencia de los datos</td>
  </tr>  
  <tr>
          <td>PilaCamisetas.java</td>
          <td>Esta clase plementa dos pilas que gestionan los diferentes archivos.txt y pilas de camisetas en la aplicación</td>
  </tr>
  <tr>
          <td>NodoUsuario.java</td>
          <td>Esta clase implementa los atributos y metodos necesarios para cargar la información de usuario en la lista usuario</td>
  </tr>
  <tr>
          <td>NodoCamiseta.java</td>
          <td>Esta clase implementa los atributos y metodos necesarios para cargar la información de las camisetas en las pilas</td>
  </tr>
  <tr>
          <td>Estilos.css</td>
          <td>Esta hoja.css implemeta los estlos para la vista principal</td>
  </tr>
          
</table>

<table align="center"> 
      <tr>
            <h3 align="center">Tabla de Vistas</h3>
      </tr>
      <tr>
            <th>Vista</th>
            <th>Controllador</th>
            <th>Cescripción</th>
      </tr>
      <tr>
            <td>Catalogo.fxml</td>
            <td>CatalogoController.java</td>
            <td>El .fxml es la vista hecha con javaFx, el contrrolador se encarga de implementar he asignar las acciones de los botones y demás</td>
      </tr>
      <tr>
            <td>View_Login.fxml</td>
            <td>LoginController.java</td>
            <td>El .fxml es la vista hecha con javaFx, el controlador se encarga de implementar los eventos onClick </td>
      </tr>
      <tr>
            <td>Registro.fxml</td>
            <td>RegistroController.java</td>
            <td>El .fxml es la vista hecha con javaFx, el contrrolador se encarga de implementar los metodos de escritura y lectura de los datos de los usuarios</td>
      </tr>
</table>

---
## Prototipo

Vea el prototipo aquí: [Prototipo en Figma](https://www.figma.com/proto/y6njOAZyOnvreOYK9qsKUx/Untitled?node-id=1-3&t=K4mmtay3bp91yvfz-1&starting-point-node-id=1%3A3)
