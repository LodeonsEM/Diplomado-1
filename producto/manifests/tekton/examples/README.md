# Tekton
-  Es un marco de código abierto para construir y desplegar software de manera automatizada en entornos de contenedores.
-  Se centra en la creación de pipelines declarativos y reutilizables para la automatización de tareas en el desarrollo y despliegue de aplicaciones.

# Elementos principales para creacion de una tarea de tekton

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

# El siguiente ejemplo se mostrara una ejecucion de una tarea en tekton que arrojara como resultado "Hello, World from Tekton!"

Se genera un archivo llamado "hello-word-task.yaml" con la tarea para mostrar el mensaje
![image](https://github.com/user-attachments/assets/9373da38-74ef-45f2-9ff5-26a446ccc60d)

Se realiza el despliegue de la tarea hello-word-task.yaml con el siguiente comando:
kubectl apply -f hello-world-task.yaml -n diploe2-emm

Se verifica que la task fue desplegada:
![image](https://github.com/user-attachments/assets/1dd2c70e-dc52-46e6-a391-507e9dc192c5)

Se genera un archivo llamado "hello-word-run.yaml" el cual ejecutara la tarea anteriormente generada
![image](https://github.com/user-attachments/assets/c2cd1b22-468e-4e6e-b31b-007bc889d47c)

Se realiza el despliegue de taskrun hello-word-run.yaml con el siguiente comando:
kubectl create -f hello-word-run.yaml -n diploe2-emm

Se verifica que el taskrun se ejecutara correctamente:
![image](https://github.com/user-attachments/assets/b12f6dc4-d0e8-4759-afcd-1b8c947980c7)

Se verifica el pod que se genero al ejecutar el task
![image](https://github.com/user-attachments/assets/4a0150cf-4304-410b-affd-be0f1d063558)

Se reviza el resultado de la task a travez de los logs generado por el pod
![image](https://github.com/user-attachments/assets/46262016-0ea9-48e2-a7c1-12e7f950d891)

# El siguiente ejemplo se mostrara como se realiza la creacion de una imagen con task de Tekton, descargandolo desde el repositorio git el codigo, creando con maven la imagen y subir la imagen al repositorio de Dockerhub

Se instala en el namespace la Task de git-clone de la siguiente manera:
kubectl apply -f https://api.hub.tekton.dev/v1/resource/tekton/task/git-cli/0.4/raw -n diploe2-emm

Generamos el manifiesto git-clon.yaml que tendra el taskrun que descargara el codigo que se encuentra en el repositorio de Git:
![image](https://github.com/user-attachments/assets/efec906f-5255-4a1b-8ee8-63fe67c2df41)

Ya que tenemos clonado el repositorio, se enlistara el contenido del directorio para esto se instalara en el namespace la task siguiente:
kubectl apply -f https://raw.githubusercontent.com/redhat-scholars/tekton-tutorial/refs/heads/master/
workspaces/list-directory-task.yaml -n diploe2-emm

Verificamos que la tarea se encuentr en el namespace
![image](https://github.com/user-attachments/assets/48ec0255-5717-4f86-854f-d036bf9e2dff)

Generamos el manifiesto list-directory.yaml que mostrara el contenido del directorio que se descargo
![image](https://github.com/user-attachments/assets/0db9c360-a7c9-48fd-b45d-b138e5d414d4)

Creamos el taskrun en el namespace con el siguiente comando
kubectl create -f list-directory.yaml  -n diploe2-emm

Verificamos si el taskrun se encuentra en ejecucion
![image](https://github.com/user-attachments/assets/2fed71a6-9a2f-400d-a6da-a810a892c6be)

Verificamos los pods creados por la task
![image](https://github.com/user-attachments/assets/85412a64-7702-4543-ad72-9efe020d2e7b)

se revisa los logs que se generaron en los pods con el resultado de las tarea en este caso enlista el contenido del directorio
![image](https://github.com/user-attachments/assets/de053888-cad5-49b7-963c-bf6b1a478c8d)

Una vez que se verifico que el contenido del directorio es el correcto instalamos en el namespace el task de maven con el siguiente comando
kubectl apply -f https://api.hub.tekton.dev/v1/resource/tekton/task/maven/0.4/raw -n diploe2-emm

Se verifica que la tarea se encuentre en el namespace
![image](https://github.com/user-attachments/assets/5294423d-bf0a-4c72-823d-3fd7e78d1893)

Se Genera el manifiesto maven-taskrun.yaml que generara el .jar de la aplicacion
![image](https://github.com/user-attachments/assets/d441cc55-3b75-42c9-a1dd-3423968c6501)

Creamos el taskrun de maven-taskrun.yaml con el siguiente comando
kubectl create -f maven-taskrun.yaml -n diploe2-emm

Verificamos si el taskrun se encentra en ejecucion
![image](https://github.com/user-attachments/assets/d9f2fa76-fd57-40ce-b4cf-77524684ddb3)

Verificamos los pods creados por la task
![image](https://github.com/user-attachments/assets/b1cfa9b1-24ce-4f7e-95c2-51ec8ad96d11)

Revisamos los logs de los pods generados por las tarea de maven
![image](https://github.com/user-attachments/assets/341c63f5-6b61-4493-8ab4-eaacfc83fb74)

Construyendo el .jar de la aplicacion
![image](https://github.com/user-attachments/assets/955f5cd2-a051-434a-90e7-0c051163e771)

Una vez creado el .jar de la aplicacion se contenderizara en una imagen Docker y se subira al repositorio dockerhub

Se debe de instalar la task "buildah" con el sigiente comando
kubectl apply -f https://api.hub.tekton.dev/v1/resource/tekton/task/buildah/0.9/raw

Se verifica que la tarea se encuentre en el namespace
![image](https://github.com/user-attachments/assets/ba982ac0-4c55-4ca9-be7d-a26e0ae18315)

Se genera el manifiesto build-taskrun.yaml que generara la imagen docker y la subira a dockerhub
![image](https://github.com/user-attachments/assets/c10a31f1-a1cb-4c69-91cb-a1a7c9829d16)

Se genere el secret para autentificarce en el repositorio de dockerhub al subir la imagen docker
![image](https://github.com/user-attachments/assets/f353dbc2-defe-4238-92ae-f6be01e19ff6)

Creamos el taskrun de build-taskrun.yaml con el siguiente comando
kubectl create -f build-taskrun.yaml -n diploe2-emm

Verificamos si el taskrun se encentra en ejecucion
![image](https://github.com/user-attachments/assets/269f2c8b-4391-4e4e-9d03-cd2ff72569a8)

Revisamos los logs de los pods generados por las tarea de buildah
![image](https://github.com/user-attachments/assets/2d6218ad-a860-493e-81d1-91d97e9e5dd6)

Se revisa en el repositorio de dockerhub se la imagen de contenedor fue subida
![image](https://github.com/user-attachments/assets/fd545f3a-9601-4e96-b674-5974cfaa1d84)




