# Start Minikube with extra resources for your CDP
minikube start --cpus 4 --memory 8192 --addons=ingress,metallb

# Configure MetalLB (Local IP Provider)
# Minikube will ask for an IP range. Use: 192.168.49.100-192.168.49.110
minikube addons configure metallb



#Load Balancer Start IP: 192.168.49.100
#
#Load Balancer End IP: 192.168.49.110