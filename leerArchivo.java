public void requestBegin(SCESession mySession) {
		// TODO Auto-generated method stub
		super.requestBegin(mySession);
		
		String cadena = mySession.getVariableField(IProjectVariables.RUTA_ARCHIVO).getStringValue();
		String cedula = mySession.getVariableField(IProjectVariables.PAC_NUM_DOC, IProjectVariables.PAC_NUM_DOC_FIELD_VALUE).getStringValue();
		String resultado = "";	
		
		try {
			
			 resultado = muestraContenido(cadena, cedula);
			 
			 System.out.print("El resultado es " + resultado);
			 System.out.print("\n");
			
			 mySession.getVariableField(IProjectVariables.RESULTADO_DOC).setValue(resultado);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public String muestraContenido(String cadena, String cedula) throws FileNotFoundException, IOException {
	      
          final FileReader filereader = new FileReader(cadena);
          final BufferedReader buffer = new BufferedReader(filereader);
          String linea = buffer.readLine().trim();
          
          while (linea != null) 
          {
              if (linea.trim().contains(cedula)){
            	  
            	  System.out.print("\n");
            	  System.out.print("Cedula Encontrada");
            	  System.out.print("\n");
            	
            	  return "Si";

              }
              
              
              linea = buffer.readLine();
              
          }
         
          buffer.close();
          filereader.close();
          
          
          System.out.print("Cedula no encontrada");
          System.out.print("\n");
          return "No";
       
	}
