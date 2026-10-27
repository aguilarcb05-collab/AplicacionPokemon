# 📱 LePokedex - Actividad 1.5

![Android](https://img.shields.io/badge/Platform-Android-green.svg)
![Language](https://img.shields.io/badge/Language-Java-orange.svg)
![Course](https://img.shields.io/badge/CFGS-DAM-blue.svg)

**LePokedex** es una aplicación móvil nativa para Android desarrollada en Java. Su objetivo es permitir a los usuarios gestionar de forma cómoda y organizada su propia lista personalizada de Pokémon, ofreciendo funcionalidades completas para listar, filtrar, consultar, crear, editar y eliminar registros (operaciones CRUD).

---

## 🏫 Contexto Académico

* **Centro Educativo:** I.E.S. Francisco Rodríguez Marín (Osuna, Sevilla)
* **Titulación:** 2º C.F.G.S. Desarrollo de Aplicaciones Multiplataforma (DAM)
* **Módulo Profesional:** Programación Multimedia y Dispositivos Móviles
* **Resultado de Aprendizaje (RA1):** Aplica tecnologías de desarrollo para dispositivos móviles evaluando sus características y capacidades.
  * *Criterios de Evaluación:* a, b, c, d, e, f, g, h.

---

## ✨ Características y Funcionalidades

### 1. 🏠 Pantalla de Inicio (Lista de Pokémon)
* Muestra el listado de todos los Pokémon registrados con sus estadísticas principales (**HP, Ataque, Defensa y Velocidad**).
* **Identificación por colores:** Los elementos de la lista adaptan su color de fondo en función del tipo de Pokémon (ej. Eléctrico: amarillo, Fuego: rojo, Agua: azul, etc.).
* **Filtro por tipo:** Incluye un menú desplegable (`Spinner`) y un botón "Filter" para filtrar el listado según el tipo seleccionado.
* Botón destacado para acceder al formulario de **creación de un nuevo Pokémon**.

### 2. 👁️ Vista Detallada de Pokémon
* Muestra la información completa del Pokémon seleccionado.
* Incluye una imagen o representación gráfica distintiva de su **tipo**.
* Opciones desde esta pantalla:
  * Volver a la lista principal (**Back**).
  * Editar los datos del Pokémon (**Edit**).
  * Eliminar el registro (**Delete**).

### 3. 📝 Agregar y Editar Pokémon
* Mismo formulario reutilizable tanto para el alta como para la modificación de registros.
* Generación automática del identificador único (**ID**).
* **Validación de campos:** Garantiza que todos los campos requeridos estén cumplimentados adecuadamente antes de guardar, mostrando advertencias en caso contrario.
* Opción de **Cancelar / Back** para deshacer o cancelar la operación.
* Confirmación visual mediante avisos en pantalla (Toast/Snackbar) tras completar con éxito una operación.

### 4. 🗑️ Eliminar Pokémon
* Permite eliminar un registro del listado de forma permanente.
* Muestra un mensaje de confirmación al usuario tras realizar la eliminación correctamente.

---

## 📐 Diseño y Wireframes

El diseño visual de la interfaz de usuario sigue estrictamente los mockups definidos en la especificación de la actividad:

| Lista Principal & Filtro | Detalle del Pokémon | Formulario (Editar / Nuevo) |
| :---: | :---: | :---: |
| Vista en lista con tarjetas coloreadas por tipo y Spinner superior. | Vista ampliada con icono/imagen por tipo y opciones de acción. | Formulario estructurado para entrada y validación de datos. |

---

## 🛠️ Tecnologías Utilizadas

* **SO Destino:** Android (SDK versión recomendada en `build.gradle`)
* **Lenguaje:** Java
* **IDE:** Android Studio
* **Componentes UI:** `RecyclerView` / `ListView`, `Spinner`, `EditText`, `Button`, `CardView`.

---

## 🚀 Instalación y Ejecución

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/tu-usuario/LePokedex.git
   ```
2. **Abrir el proyecto:**
   * Abre **Android Studio**.
   * Selecciona `File > Open...` y navega hasta el directorio del proyecto clonado.
3. **Sincronizar Gradle:**
   * Deja que Android Studio descargue las dependencias requeridas (Gradle Sync).
4. **Ejecutar:**
   * Conecta un dispositivo físico con depuración USB activada o inicia un **Emulador Android (AVD)**.
   * Presiona el botón **Run** (`Shift + F10`).

---

## 📦 Entrega del Proyecto

* **Formato comprimido:** `.zip` de la carpeta raíz del proyecto (excluyendo carpetas `build/` e `.idea/`).
* **Código Fuente:** Alojado en repositorio público/privado asignado (GitHub/GitLab).
