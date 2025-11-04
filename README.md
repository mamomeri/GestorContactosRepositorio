GestorContactos/
├─ pom.xml
├─ README.md
├─ .gitignore
├─ src/
│  ├─ main/
│  │  ├─ java/
│  │  │  └─ ec/espol/gestorcontactos/
│  │  │     ├─ app/
│  │  │     │  ├─ App.java                      # JavaFX Application; aplica tema AtlantaFX (PrimerLight/Dark)
│  │  │     │  └─ ThemeConfig.java              # helper para setUserAgentStylesheet / switches de tema
│  │  │     ├─ ds/                              # (Data Structures propias del curso)
│  │  │     │  ├─ listas/
│  │  │     │  │  ├─ ListaCircularDoble.java    # genérica: add, remove, iterator, prev/next (circular)
│  │  │     │  │  ├─ NodoDoble.java
│  │  │     │  │  └─ IteradorLCD.java           # opcional: ListIterator-like para navegar ↔
│  │  │     │  └─ algoritmos/
│  │  │     │     ├─ MergeSortLCD.java          # ordenamiento sobre tu LCD (criterios vía Comparator)
│  │  │     │     └─ BusquedasLCD.java          # búsquedas/filtrado sobre tu LCD
│  │  │     ├─ modelo/                          # Dominio puro (sin JCF de listas)
│  │  │     │  ├─ entities/
│  │  │     │  │  ├─ Contacto.java              # abstract: id, tipo, atributos, fotos, asociados
│  │  │     │  │  ├─ Persona.java               # nombre, apellidos, fechas, etc.
│  │  │     │  │  ├─ Empresa.java               # razón social, ruc, etc.
│  │  │     │  │  ├─ Atributo.java              # (nombre/clave, valor) para el “listado maestro”
│  │  │     │  │  ├─ Foto.java                  # nombre, descripción, rutaRelativa
│  │  │     │  │  └─ ContactoRef.java           # referencia por id para “contactos relacionados”
│  │  │     │  ├─ catalogos/
│  │  │     │  │  └─ MaestroAtributos.java      # atributos comunes disponibles en el sistema
│  │  │     │  ├─ enums/
│  │  │     │  │  ├─ TipoContacto.java          # PERSONA | EMPRESA
│  │  │     │  │  └─ TipoRelacion.java          # AMISTAD, JEFE, ASISTENTE, etc.
│  │  │     │  ├─ patterns/                     # patrón creacional/estructural en el dominio
│  │  │     │  │  ├─ factory/                   # ContactoFactory (plantillas Persona/Empresa)
│  │  │     │  │  └─ builder/                   # ContactoBuilder / EventoBuilder si crece
│  │  │     │  └─ colecciones/                  # uso interno del dominio con tu LCD
│  │  │     │     ├─ ListaContactos.java        # wrap de ListaCircularDoble<Contacto>
│  │  │     │     └─ ListaFotos.java            # wrap de ListaCircularDoble<Foto>
│  │  │     ├─ servicios/                       # Lógica de negocio sobre tus estructuras propias
│  │  │     │  ├─ interfaces/
│  │  │     │  │  ├─ IAgendaService.java        # CRUD, navegar circular ↔, asociados
│  │  │     │  │  ├─ IOrdenamientoService.java  # sort(criterio)
│  │  │     │  │  ├─ IFiltroService.java        # filtrar(criterio)
│  │  │     │  │  └─ IPersistenciaService.java  # guardar/cargar por serialización
│  │  │     │  ├─ impl/
│  │  │     │  │  ├─ AgendaService.java         # mantiene ListaContactos (LCD)
│  │  │     │  │  ├─ OrdenamientoService.java   # usa MergeSortLCD + Comparators
│  │  │     │  │  ├─ FiltroService.java         # Strategy de filtros (por ciudad, mes, empresa, etc.)
│  │  │     │  │  └─ SerializacionService.java  # ObjectOutputStream/ObjectInputStream
│  │  │     │  ├─ comparators/                  # criterios de orden requeridos
│  │  │     │  │  ├─ PorApellidoNombre.java
│  │  │     │  │  ├─ PorCantidadAtributos.java
│  │  │     │  │  ├─ PorCumpleanosMasCercano.java
│  │  │     │  │  ├─ PorEmpresa.java
│  │  │     │  │  ├─ PorPais.java
│  │  │     │  │  └─ PorTipoContacto.java
│  │  │     │  └─ strategy/                     # filtros/consultas reutilizables
│  │  │     │     ├─ FiltroPorCiudad.java
│  │  │     │     ├─ FiltroPorMesNacimiento.java
│  │  │     │     └─ FiltroPorAtributo.java
│  │  │     ├─ controlador/                     # @FXML controladores (sin lógica de negocio)
│  │  │     │  ├─ MainController.java
│  │  │     │  ├─ ContactoListController.java   # listado + navegación circular
│  │  │     │  ├─ ContactoEditorController.java # plantillas Persona/Empresa, CRUD atributos
│  │  │     │  └─ GaleriaController.java        # navegación circular de fotos
│  │  │     ├─ vista/                           # helpers de UI (no reglas de negocio)
│  │  │     │  ├─ ViewNavigator.java
│  │  │     │  └─ Alerts.java
│  │  │     ├─ utils/                           # utilidades transversales (no-dominio)
│  │  │     │  ├─ FechaUtils.java               # “cumpleaños más cercano”, etc.
│  │  │     │  ├─ ImageResolver.java            # carga JavaFX Image a partir de rutaRelativa
│  │  │     │  ├─ PathsConfig.java              # rutas: /data, /media (externo a resources)
│  │  │     │  └─ Ids.java                      # UUID helpers
│  │  │     └─ infra/
│  │  │        ├─ repositorio/
│  │  │        │  └─ ContactoRepositorio.java   # coordina SerializacionService + rutas
│  │  │        └─ log/                          # si configuras logging por código
│  │  └─ resources/
│  │     ├─ fxml/
│  │     │  ├─ main.fxml
│  │     │  ├─ contacto-list.fxml
│  │     │  ├─ contacto-editor.fxml
│  │     │  └─ galeria.fxml
│  │     ├─ css/
│  │     │  ├─ app.css                          # estilos propios
│  │     │  └─ atlantafx-overrides.css          # toques sobre PrimerLight/Dark si hace falta
│  │     ├─ icons/ images/                      # íconos y placeholders (no fotos de usuario)
│  │     └─ logging.properties                  # si usas java.util.logging
│  └─ test/
│     └─ java/ec/espol/gestorcontactos/
│        ├─ ds/                                 # tests de LCD, iteradores, sort
│        └─ servicios/                          # tests de filtros/ordenamientos/serialización
├─ data/                                        # (carpeta externa al jar) archivos .bin serializados
└─ media/                                       # imágenes de usuarios (rutas relativas desde aquí)
