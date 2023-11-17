package projects.apirest.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import projects.apirest.dtos.AutoDTO;
import projects.apirest.services.AutoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/autos")
public class AutoController {
    private final AutoService autoService;
    public AutoController(AutoService autoService){
        this.autoService = autoService;
    }
    @GetMapping("/")
    @Operation(summary = "Obtener todos los autos", description = "Obtiene una lista de todos los autos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de autos obtenida exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se encontraron autos")
    })
    public List<AutoDTO> getAll(){
        try {
            return autoService.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al obtener todos los autos", e);
        }
    }
    @GetMapping("auto/{id}")
    @Operation(summary = "Obtener auto por ID", description = "Obtiene un auto por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Auto encontrado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "404", description = "Auto no encontrado")
    })
    public Optional<AutoDTO> getById(@PathVariable @Parameter(description = "ID del auto", example = "1") Long id) {
        try {
            return autoService.findById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al obtener el auto por ID", e);
        }
    }
    @GetMapping("color/{color}")
    @Operation(summary = "Obtener autos por color", description = "Obtiene una lista de autos por color")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de autos obtenida exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se encontraron autos con el color especificado")
    })
    public List<AutoDTO> getByColor(@PathVariable @Parameter(description = "Color de los autos", example = "Rojo") String color) {
        try {
            return autoService.findByColor(color);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al obtener autos por color", e);
        }
    }

    @GetMapping("marca/{marca}")
    @Operation(summary = "Obtener autos por marca", description = "Obtiene una lista de autos por marca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de autos obtenida exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se encontraron autos con la marca especificada")
    })
    public List<AutoDTO> getByMarca(@PathVariable @Parameter(description = "Marca de los autos", example = "Toyota") String marca) {
        try {
            return autoService.findByMarca(marca);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al obtener autos por marca", e);
        }
    }

    @PostMapping("save")
    @Operation(summary = "Guardar un nuevo auto", description = "Guarda un nuevo auto en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Auto guardado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })
    public void saveAuto(@RequestBody @Parameter(description = "Datos del auto a guardar", example = "{\"marca\":\"Toyota\",\"color\":\"Rojo\"}") AutoDTO autoDTO) {
        try {
            autoService.saveAuto(autoDTO);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Solicitud incorrecta al guardar el nuevo auto", e);
        }
    }

    @PostMapping("saveall")
    @Operation(summary = "Guardar varios autos", description = "Guarda una lista de autos en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Autos guardados exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })
    public void saveAutos(@RequestBody @Parameter(description = "Lista de autos a guardar", example = "[{\"marca\":\"Toyota\",\"color\":\"Rojo\"},{\"marca\":\"Honda\",\"color\":\"Azul\"}]") List<AutoDTO> autosDTO) {
        try {
            autoService.saveAutos(autosDTO);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Solicitud incorrecta al guardar la lista de autos", e);
        }
    }

    @PutMapping("edit")
    @Operation(summary = "Editar un auto", description = "Edita un auto existente en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Auto editado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se encontró el auto a editar")
    })
    public void editAuto(@RequestBody @Parameter(description = "Datos del auto a editar", example = "{\"marca\":\"Toyota\",\"color\":\"Rojo\"}") AutoDTO autoDTO) {
        try {
            autoService.editAuto(autoDTO);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Solicitud incorrecta al editar el auto", e);
        }
    }

    @DeleteMapping("delete/{id}")
    @Operation(summary = "Eliminar un auto por ID", description = "Elimina un auto por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Auto eliminado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "404", description = "Auto no encontrado")
    })
    public void deleteAuto(@PathVariable @Parameter(description = "ID del auto a eliminar", example = "1") Long id) {
        try {
            autoService.deleteAuto(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al eliminar el auto por ID", e);
        }
    }
}
