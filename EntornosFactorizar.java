package prueba;
public class EntornosFactorizar {
    
    
    public double calculaDato(double precioBase, int cantidad, double descuento, double impuestos, boolean tieneTarjetaFidelidad, double saldoTarjeta, boolean esOfertaEspecial, boolean esNavidad, boolean esMiembroVip, String metodoPago, boolean aplicarCuotas, int cuota, boolean esEnvioGratis, double precioEnvio, String tipoProducto, String categoriaProducto, String codigoCupon, Usuario usuario) {
        double total = precioBase * cantidad;

       
        if (descuento > 0) {
            total -= total * (descuento / 100);
        }

   
        if (tieneTarjetaFidelidad && saldoTarjeta > 0) {
            total -= saldoTarjeta;
        }

       
        total += total * (impuestos / 100);

        if (esOfertaEspecial) {
            total *= 0.9;
        }

     
        if (esNavidad) {
            total *= 0.85;
        }

     
        if (esMiembroVip) {
            total *= 0.8;
        }

        
        if (metodoPago.equals("TarjetaCredito")) {
            total *= 1.05;
        } else if (metodoPago.equals("PayPal")) {
            total *= 1.02;
        }

      
        if (aplicarCuotas) {
            if (cuota == 3) {
                total *= 1.1;
            } else if (cuota == 6) {
                total *= 1.2;
            } else if (cuota == 12) {
                total *= 1.3;
            }
        }


        if (!esEnvioGratis) {
            total += precioEnvio;
        }

        
        if (codigoCupon != null && !codigoCupon.isEmpty()) {
            total = aplicarCuponDescuento(total, codigoCupon);
        }

    
        if (!validarProducto(tipoProducto, categoriaProducto)) {
            throw new IllegalArgumentException("El producto no es válido para esta compra.");
        }

      
        if (usuario != null) {
            total = aplicarDescuentoPorUsuario(usuario, total);
        }

     
        if (total < 0) {
            total = 0;
        }

        return total;
    }

  	private double aplicarCuponDescuento(double total, String codigoCupon) {
		/*
		 * if (codigoCupon.equals("CUPOFF")) { total *= 0.8; } else if
		 * (codigoCupon.equals("NAVIDAD2025")) { total *= 0.75; }
		 */
		// creamos una variable descuento que dependiendo del cupon tendra un valor
		// diferente , y devuelve el total con el descuento aplicado
		double descuento;
		switch (codigoCupon) {
		case "CUPOFF":
			descuento = 0.8;
			break;
		case "NAVIDAD2025":
			descuento = 0.75;
			break;

		default:
			descuento = 1.0; // No se aplica descuento
		}
		return total * descuento;
	}
   
    private boolean validarProducto(String tipoProducto, String categoriaProducto) {//Usamos las coleccion set para eliminar los duplicados , 
		//Con el .of introducimos los valores, significa que solo va a contener esos valores como por defecto 
        //no puede agregar ni eliminar ni modificar nada de esa lisa
		//, con el map lo comparamos por clave 
		Set<String> categoriasElectronico = Set.of("Smartphones");
		Set<String> categoriasRopa = Set.of("Hombre", "Mujer");

		Map<String, Set<String>> productosValidos = Map.of(
				"Electronico", categoriasElectronico,
				"Ropa",categoriasRopa);

		return productosValidos.containsKey(tipoProducto) && productosValidos.get(tipoProducto).contains(categoriaProducto);
    }

   
    private double aplicarDescuentoPorUsuario(Usuario usuario, double total) {
        if (usuario.esEmpleado()) {
            total *= 0.7; 
        } else if (usuario.esMiembroGold()) {
            total *= 0.85;  
        } else if (usuario.esMiembroSilver()) {
            total *= 0.9; 
        }
        return total;
    }
}
