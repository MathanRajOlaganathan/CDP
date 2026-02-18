
    Docker containers are isolated Linux processes that share the host kernel, unlike VMs which run separate operating systems

![dockee-arch.png](dockee-arch.png)

 **Core building blocks (internal)**

Docker mainly relies on 4 Linux primitives:

1. Feature	Purpose
2. Namespaces	Isolation
3. cgroups	Resource limits
4. Union File System	Images & layers
5. Daemon (dockerd)	Container lifecycle


**Docker daemon flow (what happens when you run a container)**

When you run:

    docker run mysql

Internally:

1. CLI sends request to dockerd
2. dockerd pulls image (if needed)
3. Creates:
   * namespaces
   * cgroups
   * filesystem layers
7. Starts MySQL as a Linux process
8. Attaches networking & ports

👉 It’s just a process, not a VM.


**Networking (simple view)**

* Docker creates a bridge network
* Containers get private IPs
* Port mapping:


    localhost:3306 → container:3306


**containerd is a daemon that:**

1. Pulls images
2. Creates containers
3. Starts/stops containers
4. Manages container lifecycle

It talks directly to the Linux kernel (via runc).

👉 containerd does not:

1. Build images
2. Provide CLI UX
3. Manage Dockerfiles


**containerd + runc explained**

containerd
1. Manages containers
2. High-level runtime

runc

1. Low-level
2. Actually sets namespaces & cgroups
3. Executes the process

👉 runc does the real isolation work.

**Why Kubernetes uses containerd (not Docker)**

1. Originally: Kubernetes used Docker
2. Now: Kubernetes uses containerd directly
3. Why?  Docker does too much
4. Kubernetes only needs: Start / stop containers  Pull images

This is why:

Docker was removed as a Kubernetes runtime (Dockershim removed)

**TL;DR**

* Docker = convenience + tooling
* containerd = runtime
* runc = isolation execution
* Kernel = actual enforcer

**docker compose**

1. Command,Action,Removes Containers?,Removes Networks?
2. up,Create + Start,No,No
3. down,Stop + Remove,Yes,Yes
4. start,Power On,No,No
5. stop,Power Off,No,No



![Screenshot 2026-02-02 at 18.23.59.png](Screenshot%202026-02-02%20at%2018.23.59.png)