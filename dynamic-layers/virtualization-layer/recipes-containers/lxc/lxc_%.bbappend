FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://0001-Update-busybox-template-to-handle-nosuid-suid-flavor.patch \
			file://0002-lxc-network-Add-corner-case-on-ifup.patch"
