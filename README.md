# Informe de Práctica: Refactorización en Entornos de Desarrollo

Este documento detalla el proceso de análisis, limpieza y refactorización realizado sobre la clase `ProcesadorPedidos.java`. El objetivo ha sido mejorar la legibilidad y mantenibilidad del código ("Clean Code") utilizando herramientas de análisis estático y refactorización automatizada, asegurando la integridad del software mediante pruebas unitarias.

## 1. Fase 1: Análisis Estático y Configuración

Antes de modificar el código, se realizó una auditoría utilizando el plugin **SonarLint** para detectar "Code Smells".

### Detección de Magic Numbers
**Captura 1:** En esta imagen se muestran las sugerencias que ofrece el plugin SonarQube/SonarLint. Se detecta el uso de "números mágicos" (literales numéricos sin explicación en el código, como `0.10`) y se sugiere extraerlos a constantes con nombres descriptivos.


### Configuración de Reglas
**Captura 2:** Aquí se muestra el editor con la regla de "Magic Numbers" desactivada temporalmente (o configurada con menor prioridad). Se observa que los subrayados de advertencia han desaparecido, lo que nos permite verificar que tenemos control sobre la configuración de las reglas de análisis estático.



## 2. Fase 3: Refactorización Automatizada

Se utilizaron las herramientas de refactorización automática del IDE (Eclipse) para realizar los cambios de forma segura, minimizando el error humano.

**Captura 3:** Vista de las herramientas de refactorización en Eclipse antes de aplicar un cambio complejo. Se utiliza el menú contextual (*Refactor*) para acceder a funciones como `Extract Method` o `Extract Constant`, permitiendo previsualizar y organizar la estructura del código antes de confirmar la modificación.




## 3. Fase 2 y 4: Verificación (Red de Seguridad)

La refactorización se basa en el principio de no alterar el comportamiento externo del código. Para ello, se creó una suite de pruebas con **JUnit**.

**Captura 4:** Verificación final. Tras cada cambio aplicado (renombrado, extracción de constantes, extracción de métodos), se ejecutó el test unitario. La barra verde confirma que todos los tests han pasado exitosamente y que la lógica de negocio se mantiene intacta tras la refactorización.



## 4. Tabla Resumen de Patrones de Refactorización

A continuación se detallan los patrones aplicados para limpiar el código:

| Patrón Aplicado | Descripción | Cambio Realizado (Antes &rarr; Después) |
| :--- | :--- | :--- |
| **Rename Variable** | Se cambiaron nombres de variables crípticos (una sola letra) por nombres auto-explicativos. | • `a` &rarr; `listaNombres`<br>• `b` &rarr; `precios`<br>• `t` &rarr; `totalSinImpuestos`<br>• `res` &rarr; `resultadoTotal` |
| **Extract Constant** | Se eliminaron los "números mágicos" sustituyéndolos por constantes estáticas finales. | • `0.10` &rarr; `DESCUENTO`<br>• `0.21` &rarr; `IVA`<br>• `15.95` &rarr; `GASTOS_DE_ENVIO` |
| **Extract Method** | Se redujo la complejidad del método principal extrayendo lógica específica a métodos privados independientes. | • Lógica del 21% &rarr; método `calcularImpuestos(...)`<br>• Lógica de envío (< 500) &rarr; método `calcularEnvio(...)` |

