DESCRIPTION = "i.MX U-Boot suppporting i.MX reference boards."

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

UBOOT_SRC ?= "git://github.com/nxp-imx/uboot-imx.git;protocol=https"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH} \
	file://efi.cfg \
        file://extra.cfg \
"
SRCBRANCH = "lf_v2024.04"
LOCALVERSION ?= "-${SRCBRANCH}"
SRCREV = "de16f4f17221b2ff72b8cb18c28cd8a29f3c2710"

FILESEXTRAPATHS:prepend := "${COREBASE}/meta/recipes-bsp/u-boot/files:"
SRC_URI += "file://CVE-2024-57254.patch \
	file://CVE-2024-57255.patch \
	file://CVE-2024-57256.patch \
	file://CVE-2024-57257.patch \
"

DEPENDS += " \
    bc-native \
    bison-native \
    dtc-native \
    flex-native \
    gnutls-native \
    xxd-native \
"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

inherit fsl-u-boot-localversion

BOOT_TOOLS = "imx-boot-tools"
