package com.vampiro.springboot.backen.apirest.controllers;


import java.io.IOException;
import java.net.MalformedURLException;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vampiro.springboot.backen.apirest.models.entity.Producto;
import com.vampiro.springboot.backen.apirest.models.services.IProductoService;
import com.vampiro.springboot.backen.apirest.models.services.IUploadFileService;

@CrossOrigin(origins = {"http://localhost:4200","*"})
@RestController
@RequestMapping("/api")
public class ProductoRestController {
	
	@Autowired
	private IProductoService productoService;

	@Autowired
	private IUploadFileService uploadService;

	//LISTAR
	@GetMapping("/productos")
	public List<Producto> index(){
		return productoService.findAllOrderByIdDesc();
	}

	@GetMapping("/productos/page/{page}")
	public Page<Producto> index(@PathVariable Integer page){
		return productoService.findAll(PageRequest.of(page, 12));
	}


	@GetMapping("/productos/{id}")
	//@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> show(@PathVariable Long id) {

		Producto producto = null;
		Map<String, Object> response = new HashMap<>();

		try {
			producto = productoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if(producto == null) {
			response.put("mensaje", "El producto ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Producto>(producto, HttpStatus.OK);

	}

	@GetMapping("/productos/filtrar/{nombre}")
	public Producto buscarProducto(@PathVariable String nombre) {
		return productoService.findByNombre(nombre);
	}

	@GetMapping("/productos/buscar/{nombre}")
	@ResponseStatus(HttpStatus.OK)
	public List<Producto> filtrarProducto(@PathVariable String nombre){
		return productoService.findByNombreContainingIgnoreCase(nombre);
	}

	@GetMapping("/productos/filter/{precio}")
	public List<Producto> filterProductByPrice(@PathVariable Double precio
											   ){
		List<Producto> productos = productoService.findByPrecioGreaterThan(precio);
		return productos;
	}

    @GetMapping("productos/filt")
    public List<Producto> testProducts(@RequestParam(value = "precio", required = false) Double precio,
                                       @RequestParam(value = "nombre", required = false) String nombre){

        List<Producto> productos;


        if(precio == null && nombre == null){
            productos = null;
        }else{
            if(precio!= null){
                productos = productoService.findByPrecioGreaterThan(precio);
                return productos;
            }
            if(nombre != null){
                productos = productoService.findByNombreContainingIgnoreCase(nombre);
                return productos;
            }
        }
        productos = productoService.findAll();
        return productos;

    }

	@GetMapping("/productos/categoria/{nombre}")
	public List<Producto> filterProductByCategory(@PathVariable String nombre){
		return productoService.findByCategoriaNombre(nombre);
	}

	@PostMapping("/productos/file")
	public ResponseEntity<?> createProductoUpload(@RequestParam("producto") String productoJsonString,
												  @RequestParam("archivo") MultipartFile archivo) {
		Producto producto = null;
		String nombreArchivo = null;
		try {
			producto = new ObjectMapper().readValue(productoJsonString, Producto.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(!archivo.isEmpty()){
			try {
				nombreArchivo = uploadService.copiar(archivo);
			} catch (IOException e) {
				e.printStackTrace();
			}
			producto.setImagen(nombreArchivo);
		}
		Producto productoNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			productoNew = productoService.save(producto);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			//response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El producto '" + productoNew.getNombre() +"' ha sido creado con éxito!" );
		response.put("producto", productoNew);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
	}

	//GUARDAR
	/*//ANTERIOR AL JDK 8
			List<String> errors = new ArrayList<>();

			for (FieldError err : result.getFieldErrors()) {
				errors.add("El campo '" + err.getField() + "' "+ err.getDefaultMessage());
			}
		*/
	@PostMapping("/productos")
	public ResponseEntity<?> create(@Valid @RequestBody Producto producto, BindingResult result) {
		Producto productoNew = null;
		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}try {
			productoNew = productoService.save(producto);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			//response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El producto '" + productoNew.getNombre() +"' ha sido creado con éxito!" );
		response.put("producto", productoNew);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
	}


	//ACTUALIZAR
	@PutMapping("/productos/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Producto producto, BindingResult result, @PathVariable Long id) {
		Producto productoActual = productoService.findById(id);
		Map<String, Object> response = new HashMap<>();
		Producto productoUpdate = null;
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map( err -> "El campo '" + err.getField() + "' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		if(productoActual == null) {
			response.put("mensaje", "Error, no se pudo editar, el producto ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}try {
			productoActual.setNombre(producto.getNombre());
			productoActual.setDescripcion(producto.getDescripcion());
			productoActual.setPrecio(producto.getPrecio());
			productoActual.setStock(producto.getStock());
			productoActual.setCategoria(producto.getCategoria());
			productoUpdate = productoService.save(productoActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el producto en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El producto '"+productoUpdate.getNombre()+"' ha sido actualizado con éxito!" );
		response.put("producto", productoUpdate);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/productos/{id}")
	//@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			Producto producto = productoService.findById(id);
			String nombreFotoAnterior = producto.getImagen();
			uploadService.eliminar(nombreFotoAnterior);
			productoService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el producto de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El producto fue eliminado con éxito!");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}

	@PostMapping("/productos/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		Map<String, Object> response = new HashMap<>();
		Producto producto = productoService.findById(id);
		if(!archivo.isEmpty()) {
			String nombreArchivo = null;
			try {
				nombreArchivo = uploadService.copiar(archivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen del producto ");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			String nombreFotoAnterior = producto.getImagen();
			uploadService.eliminar(nombreFotoAnterior);
			producto.setImagen(nombreArchivo);
			productoService.save(producto);
			response.put("producto", producto);
			response.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@GetMapping("/uploads/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto){
		Resource recurso = null;
		try {
			recurso = uploadService.cargar(nombreFoto);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
	}

}
