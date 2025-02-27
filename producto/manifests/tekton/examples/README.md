Tekton
-  Es un marco de código abierto para construir y desplegar software de manera automatizada en entornos de contenedores.
-  Se centra en la creación de pipelines declarativos y reutilizables para la automatización de tareas en el desarrollo y despliegue de aplicaciones.

* Elementos principales para creacion de una tarea de tekton
Step:
- Unidad más pequeña para ejecutar comandos o scripts
- Un contenedor
Task:
- Una secuencia de pasos
- Un Pod con anulación del punto de entrada
- Una abstracción de componente reusable
Pipeline:
- Un grafico acíclico dirigido de tareas
- Datos compartidos entre tareas a través de resultados y espacio de trabajo (volumen persistente)
- Uso de sintaxis como re-intentos, cuándo y finalmente para gestionar el flujo de trabajo
Workspace: Espacio del cluster de trabajo
Results: Mensaje de terminación de tarea

* El siguiente ejemplo se mostrara una ejecucion de una tarea en tekton que arrojara como resultado "Hello, World from Tekton!"

Se genera un archivo llamado "hello-word-task.yaml" con la tarea para mostrar el mensaje
![image](https://github.com/user-attachments/assets/9373da38-74ef-45f2-9ff5-26a446ccc60d)

Se realiza el despliegue de la tarea hello-word-task.yaml con el siguiente comando:
# kubectl apply -f hello-world-task.yaml -n diploe2-emm

Se verifica que la task fue desplegada:
![image](https://github.com/user-attachments/assets/1dd2c70e-dc52-46e6-a391-507e9dc192c5)

Se genera un archivo llamado "hello-word-run.yaml" el cual ejecutara la tarea anteriormente generada
![image](https://github.com/user-attachments/assets/c2cd1b22-468e-4e6e-b31b-007bc889d47c)

Se realiza el despliegue de taskrun hello-word-run.yaml con el siguiente comando:
# kubectl create -f hello-word-run.yaml -n diploe2-emm

Se verifica que el taskrun se ejecutara correctamente:
![image](https://github.com/user-attachments/assets/b12f6dc4-d0e8-4759-afcd-1b8c947980c7)

Se verifica el pod que se genero al ejecutar el task
![image](https://github.com/user-attachments/assets/4a0150cf-4304-410b-affd-be0f1d063558)

Se reviza el resultado de la task a travez de los logs generado por el pod
![image](https://github.com/user-attachments/assets/46262016-0ea9-48e2-a7c1-12e7f950d891)




