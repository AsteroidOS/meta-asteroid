# ~/.bashrc: executed by bash(1) for non-login shells.

umask 022

export DBUS_SESSION_BUS_ADDRESS=unix:path=${XDG_RUNTIME_DIR}/dbus/user_bus_socket

export PS1='\u@\h:\W\$ '
export LS_OPTIONS='--color=auto'
alias ls='ls $LS_OPTIONS'
alias ll='ls $LS_OPTIONS -l'
alias l='ls $LS_OPTIONS -lA'
