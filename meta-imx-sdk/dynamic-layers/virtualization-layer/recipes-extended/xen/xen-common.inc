SRCBRANCH = "lf-6.6.36_2.1.0"
XEN_SRC ?= "git://github.com/nxp-imx/imx-xen.git;protocol=https"
SRC_URI = " ${XEN_SRC};branch=${SRCBRANCH}"
SRCREV = "9bfc997049c91fe0b28885fb8e3e77b0377843cb"
XEN_REL = "4.18.imx"
PV = "${XEN_REL}+stable"