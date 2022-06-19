Feature: Registrar Categoría

	Scenario: Registrar Categoria Exitosa
		Given cargo la página login del aplicativo Visor Web
		  And inicio sesión con el usuario "admin" y la clave "clave"
		 When ingreso a la pagina registrar categoría
		  And escribo la categoría "MESA" y hago clic en el botón guardar
		 Then el aplicativo muestra el mensaje "Se guardó de manera correcta la Categoría"
	
	Scenario: Registrar Categoria Vacía
	  Given cargo la página login del aplicativo Visor Web
		  And inicio sesión con el usuario "admin" y la clave "clave"
		 When ingreso a la pagina registrar categoría
		  And escribo la categoría "" y hago clic en el botón guardar
		 Then el aplicativo muestra el mensaje "Nombre: Error de validación: se necesita un valor."

