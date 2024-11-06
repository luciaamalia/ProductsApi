# Comandos Docker 

### Subir uma nova máquina com os bancos de dados configurados no docker-compose.yml
```
docker compose up
```

### Verificar o status e os ID dos containers
```
docker ps
```

### Matar um container específico
```
docker kill id-container
```

### Excluir resquícios de containers, volumes e redes parados
```
docker system prune --volumes
```

### Iniciar um container
```
docker start id-container
```

### Parar um container
```
docker stop id-container
```

### Reiniciar um container
```
docker restart id-container
```

### Remover um container parado
```
docker rm id-container
```

### Verificar logs de um container
```
docker logs id-container
```

### Acessar o terminal de um container em execução
```
docker exec -it id-container /bin/bash
```
