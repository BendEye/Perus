# Perus
An open-source AntiCheat that will eventually contain the following.


- Base of AntiCheat  
  - Alert System
    - Log violation into the log system and doesn't reset on disconnect
  - Check System
  - PacketListener via ProtocolLib
    - Join/Leave(Sending, Receiving)
  - Data System
    - Processes PlayerData Movements
    - Processes PlayerData Rotations
    - Processes PlayerData Actions
    - Processes PlayerData Connections
    - Processes PlayerData Packets
  - File System
    - Contains Config.yml, Checks.yml, Logs folder and Log.yml
  - Config System
    - Enable/disable checks
    - Set own violations per check
    - Change plugin name
    - Choose log system 
    - Set permission per command
    - Set main command
  - Punishment System
    - Send out a command after reaching the max violation set in checks.yml
    - 
  - Log System
    - Flat file
    - MongoDB
    - MySql
    - Redis
- Things I wish to implement into Perus
  - Utilizing Pledge into the AntiCheat
    - Transaction listener
    - Connection Listener
    - Velocity Listenr